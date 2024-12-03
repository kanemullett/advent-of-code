package challenges.aoc2024.day3.model;

import java.util.regex.Matcher;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day3.util.DayThreeConstants;

/**
 * MultiplicationInstruction object for storing the multiplicands of an instruction.
 */
@Immutable
public interface MultiplicationInstruction {
    
    /**
     * The first multiplicand.
     * 
     * @return The first multiplicand.
     */
    Integer getFirstValue();

    /**
     * The second multiplicand.
     * 
     * @return The second multiplicand.
     */
    Integer getSecondValue();

    /**
     * Build a MultiplicationInstruction object from an instruction string.
     * 
     * @param mulInstruction The instruction string.
     * 
     * @return The MultiplicationInstruction object.
     */
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

    /**
     * Build a MultiplicationInstruction object from its component multiplicands.
     * 
     * @param firstValue The first multiplicand.
     * @param secondValue The second multiplicand.
     * 
     * @return The MultiplicationInstruction object.
     */
    static MultiplicationInstruction of(Integer firstValue, Integer secondValue) {
        
        return ImmutableMultiplicationInstruction.builder()
            .firstValue(firstValue)
            .secondValue(secondValue)
            .build();
    }
}
