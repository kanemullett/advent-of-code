package challenges.aoc2024.day3.model;

import java.util.List;
import java.util.regex.Matcher;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day3.util.DayThreeConstants;

/**
 * ComputerMemorySection containing a secton of corrupted computer memory.
 */
@Immutable
public interface ComputerMemorySection {
    
    /**
     * The multiplication instructions extracted from the corrupted computer memory section.
     * 
     * @return The multiplication instructions.
     */
    List<MultiplicationInstruction> getInstructions();

    /**
     * Build a ComputerMemorySection object from a string of corrupted computer memory.
     * 
     * @param rawMemory The string of corrupted computer memory.
     * 
     * @return The ComputerMemorySection object.
     */
    static ComputerMemorySection of(String rawMemory) {
        final Matcher matcher = DayThreeConstants.MULTIPLICATION_INSTRUCTION_PATTERN.matcher(rawMemory);
        
        return ImmutableComputerMemorySection.builder()
            .instructions(matcher.results()
                .map(match -> match.group(0))
                .map(MultiplicationInstruction::of)
                .toList())
            .build();
    }
}
