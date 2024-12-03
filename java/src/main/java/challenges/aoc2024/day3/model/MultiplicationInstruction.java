package challenges.aoc2024.day3.model;

import java.util.regex.Matcher;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day3.util.DayThreeConstants;

@Immutable
public interface MultiplicationInstruction {
    
    Integer getFirstValue();

    Integer getSecondValue();

    static MultiplicationInstruction of(String mulInstruction) {
        final Matcher matcher = DayThreeConstants.MULTIPLICATION_INSTRUCTION_PATTERN.matcher(mulInstruction);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid multiplication instruction.");
        }

        return ImmutableMultiplicationInstruction.builder()
            .firstValue(Integer.parseInt(matcher.group(1)))
            .secondValue(Integer.parseInt(matcher.group(2)))
            .build();
    }

    static MultiplicationInstruction of(Integer firstValue, Integer secondValue) {
        
        return ImmutableMultiplicationInstruction.builder()
            .firstValue(firstValue)
            .secondValue(secondValue)
            .build();
    }
}
