package challenges.aoc2024.day7.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ExpressionBuilderFunctionTest {

    @Test
    void shouldBuildExpressions() {
        // Given
        final List<Long> numbers = List.of(1L, 2L, 3L);
        final ExpressionBuilderFunction expressionBuilderFunction = new ExpressionBuilderFunction();

        // When
        final List<String> expressions = expressionBuilderFunction.apply(numbers);

        // Then
        assertEquals(4, expressions.size());
        assertTrue(expressions.contains("1+2+3"));
        assertTrue(expressions.contains("1+2*3"));
        assertTrue(expressions.contains("1*2+3"));
        assertTrue(expressions.contains("1*2*3"));
    }
}
