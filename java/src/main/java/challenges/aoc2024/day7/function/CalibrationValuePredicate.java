package challenges.aoc2024.day7.function;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import challenges.aoc2024.day7.model.CalibrationEquation;

/**
 * Predicate class for determining whether the values of a calibration equation can equal the test value when joined into an expression.
 */
public class CalibrationValuePredicate implements Predicate<CalibrationEquation> {
    private final boolean includeConcatenation;

    /**
     * Predicate class for determining whether the values of a calibration equation can equal the test value when joined into an expression.
     * 
     * @param includeConcatenation True if equations can include || operator.
     */
    public CalibrationValuePredicate(boolean includeConcatenation) {
        this.includeConcatenation = includeConcatenation;
    }
    
    /**
     * Apply predicate logic to determe whether the values of a calibration equation can equal the test value when joined into an expression.
     * 
     * @param equation The calibration equation.
     * 
     * @return True if the values of a calibration equation can equal the test value when joined into an expression.
     */
    @Override
    public boolean test(CalibrationEquation equation) {
        final ExpressionBuilderFunction builderFunction = new ExpressionBuilderFunction(includeConcatenation);

        return !builderFunction.apply(equation.getCalibrationValues()).stream()
            .map(this::evaluateExpression)
            .filter(evaluated -> Objects.equals(evaluated, equation.getTestValue()))
            .toList().isEmpty();
    }

    /**
     * Evaluate the result of an expression.
     * 
     * @param expression The expression string.
     * 
     * @return The result of the expression.
     */
    private Long evaluateExpression(String expression) {

        final List<String> parts = Arrays.asList(expression.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"));

        return parts.stream()
            .reduce(
                new long[] { Long.parseLong(parts.get(0)), 0 },
                (acc, part) -> {
                    if (isOperator(part)) {
                        acc[1] = part.equals("+") ? 1 : 2;
                        if (part.equals("+")) {
                            acc[1] = 1;
                        } else if (part.equals("*")) {
                            acc[1] = 2;
                        } else {
                            acc[1] = 3;
                        }
                    } else {
                        long currentValue = acc[0];
                        long nextNumber = Long.parseLong(part);
                        acc[0] = applyOperator(acc[1], currentValue, nextNumber);
                    }
                    return acc;
                },
                (acc1, acc2) -> acc1
            )[0];
    }

    /**
     * Apply the operator to the two values either side of it.
     * 
     * @param operatorId The id of the operator.
     * @param currentValue The first value.
     * @param nextNumber The second value.
     * 
     * @return The value after applying the operator.
     */
    private Long applyOperator(Long operatorId, Long currentValue, Long nextNumber) {
        if (operatorId == 1) {
            return currentValue + nextNumber;
        } else if (operatorId == 2) {
            return currentValue * nextNumber;
        } else if (operatorId == 3) {
            return Long.parseLong(String.valueOf(currentValue) + String.valueOf(nextNumber));
        }

        return currentValue;
    }

    /**
     * Determine if a string is a mathematical operator.
     * 
     * @param part The string to check.
     * 
     * @return True if the string is a mathematical operator.
     */
    private boolean isOperator(String part) {
        return part.equals("+") || part.equals("*") || part.equals("||");
    }
}