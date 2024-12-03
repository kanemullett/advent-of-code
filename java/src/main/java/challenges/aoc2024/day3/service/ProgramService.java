package challenges.aoc2024.day3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import challenges.aoc2024.day3.model.ComputerMemorySection;
import challenges.aoc2024.day3.model.ImmutableComputerMemorySection;
import challenges.aoc2024.day3.util.DayThreeConstants;

/**
 * Service for performing operations on corrupted data from the program.
 */
public class ProgramService {
    private static final String DO_STATEMENT = "do()";
    private static final String DONT_STATEMENT = "don't()";
    
    public ProgramService() {
        // Empty constructor for dependency injection
    }

    /**
     * Calculate the total of the multiplication instructions.
     * 
     * @param rawMemory The corrupted data string.
     * @param conditionalsIntact True if conditional statements are intact.
     * 
     * @return The total of the multiplication instructions.
     */
    public Integer calculateTotalOfMultiplicationInstructions(String rawMemory, boolean conditionalsIntact) {

        ComputerMemorySection memory;
        
        if (conditionalsIntact) {
            final Matcher matcher = DayThreeConstants.DO_DONT_SECTION_PATTERN.matcher(rawMemory);

            final List<String> toCheck = new ArrayList<>(List.of(rawMemory.substring(0, rawMemory.indexOf(DONT_STATEMENT))));
            final String after = rawMemory.substring(rawMemory.lastIndexOf(DO_STATEMENT) + 4);

            // Check for unterminated 'do()' at the end of the raw input.
            if (!after.contains(DONT_STATEMENT)) {
                toCheck.add(after);
            }

            toCheck.addAll(matcher.results()
                .map(match -> match.group(1))
                .toList());

            memory = ImmutableComputerMemorySection.builder()
                .instructions(toCheck.stream()
                    .map(ComputerMemorySection::of)
                    .map(ComputerMemorySection::getInstructions)
                    .flatMap(List::stream)
                    .toList())
                .build();
        } else {
            memory = ComputerMemorySection.of(rawMemory);
        }

        return memory.getInstructions().stream()
            .map(instruction -> instruction.getFirstValue() * instruction.getSecondValue())
            .mapToInt(Integer::intValue)
            .sum();
    }
}
