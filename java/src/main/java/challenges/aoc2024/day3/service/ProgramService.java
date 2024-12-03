package challenges.aoc2024.day3.service;

import challenges.aoc2024.day3.model.ComputerMemory;

public class ProgramService {
    
    public ProgramService() {
        // Empty constructor for dependency injection
    }

    public Integer calculateTotalOfMultiplicationInstructions(ComputerMemory memory) {

        return memory.getInstructions().stream()
            .map(instruction -> instruction.getFirstValue() * instruction.getSecondValue())
            .mapToInt(Integer::intValue)
            .sum();
    }
}
