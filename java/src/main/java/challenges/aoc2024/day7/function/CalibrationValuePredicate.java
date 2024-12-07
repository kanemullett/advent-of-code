package challenges.aoc2024.day7.function;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import challenges.aoc2024.day7.model.CalibrationEquation;

public class CalibrationValuePredicate implements Predicate<CalibrationEquation> {
    
    @Override
    public boolean test(CalibrationEquation equation) {
        final ExpressionBuilderFunction builderFunction = new ExpressionBuilderFunction();

        return !builderFunction.apply(equation.getCalibrationValues()).stream()
            .map(this::evaluateExpression)
            .filter(evaluated -> Objects.equals(evaluated, equation.getTestValue()))
            .toList().isEmpty();
    }

    
    public Long evaluateExpression(String expression) {

        final List<String> parts = Arrays.asList(expression.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"));

        return parts.stream()
            .reduce(
                new long[] { Long.parseLong(parts.get(0)), 0 },
                (acc, part) -> {
                    if (isOperator(part)) {
                        acc[1] = part.equals("+") ? 1 : 2;
                    } else {
                        long currentValue = acc[0];
                        long nextNumber = Long.parseLong(part);
                        if (acc[1] == 1) {  // + operator
                            acc[0] = currentValue + nextNumber;
                        } else if (acc[1] == 2) {
                            acc[0] = currentValue * nextNumber;
                        }
                    }
                    return acc;
                },
                (acc1, acc2) -> acc1
            )[0];
    }

    private boolean isOperator(String part) {
        return part.equals("+") || part.equals("*");
    }
}