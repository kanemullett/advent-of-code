package challenges.aoc2024.day7.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Function class to generate the possible expressions from a list of numbers.
 */
public class ExpressionBuilderFunction implements Function<List<Long>, List<String>> {
    private final boolean includeConcatenation;

    /**
     * Function class to generate the possible expressions from a list of numbers.
     * 
     * @param includeConcatenation True if equations can include || operator.
     */
    public ExpressionBuilderFunction(boolean includeConcatenation) {
        this.includeConcatenation = includeConcatenation;
    }
    
    /**
     * Apply function logic to generate the possible expressions.
     * 
     * @param values The list of numbers.
     */
    @Override
    public List<String> apply(List<Long> values) {

        return generateExpressions(values, 0);
    }

    /**
     * Generate all possible expressions from a list of numbers.
     * 
     * @param numbers The numbers in the expression.
     * @param index The index to start iterating from.
     * 
     * @return The list of expressions.
     */
    private List<String> generateExpressions(List<Long> numbers, int index) {
        final List<String> result = new ArrayList<>();
        
        if (index == numbers.size() - 1) {
            result.add(String.valueOf(numbers.get(index)));
            return result;
        }

        final List<String> nextExpressions = generateExpressions(numbers, index + 1);
        nextExpressions.forEach(next -> {
            result.add(numbers.get(index) + "+" + next);
            result.add(numbers.get(index) + "*" + next);

            if (includeConcatenation) {
                result.add(numbers.get(index) + "||" + next);
            }
        });
        
        return result;
    }
}
