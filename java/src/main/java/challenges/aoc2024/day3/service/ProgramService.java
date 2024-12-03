package challenges.aoc2024.day3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import challenges.aoc2024.day3.model.ComputerMemorySection;
import challenges.aoc2024.day3.model.ImmutableComputerMemorySection;
import challenges.aoc2024.day3.util.DayThreeConstants;

public class ProgramService {
    
    public ProgramService() {
        // Empty constructor for dependency injection
    }

    public Integer calculateTotalOfMultiplicationInstructions(String rawMemory, boolean conditionalsIntact) {

        ComputerMemorySection memory;
        
        if (conditionalsIntact) {
            final Matcher matcher = DayThreeConstants.DO_DONT_SECTION_PATTERN.matcher(rawMemory);

            final List<String> toCheck = new ArrayList<>(List.of(rawMemory.substring(0, rawMemory.indexOf("don't()"))));
            final String after = rawMemory.substring(rawMemory.lastIndexOf("do()") + 4);

            toCheck.addAll(DayThreeConstants.DO_DONT_SECTION_PATTERN.matcher(after).results()
                .map(match -> match.group(1))
                .toList());

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
