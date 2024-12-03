package challenges.aoc2024.day3.model;

import java.util.List;
import java.util.regex.Matcher;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day3.util.DayThreeConstants;

@Immutable
public interface ComputerMemory {
    
    List<MultiplicationInstruction> getInstructions();

    static ComputerMemory of(String rawMemory) {
        final Matcher matcher = DayThreeConstants.MULTIPLICATION_INSTRUCTION_PATTERN.matcher(rawMemory);
        
        return ImmutableComputerMemory.builder()
            .instructions(matcher.results()
                .map(match -> match.group(0))
                .map(MultiplicationInstruction::of)
                .toList())
            .build();
    }
}
