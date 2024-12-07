package challenges.aoc2024.day7.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExpressionBuilderFunction implements Function<List<Long>, List<String>> {
    
    @Override
    public List<String> apply(List<Long> values) {

        return generateExpressions(values, 0);
    }

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
        });
        
        return result;
    }
}
