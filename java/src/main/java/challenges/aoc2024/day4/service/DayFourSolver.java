package challenges.aoc2024.day4.service;

import java.util.List;

import challenges.aoc2024.day4.model.Wordsearch;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 4 of the 2024 Advent of Code.
 */
public class DayFourSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 4);
    private final WordsearchService wordsearchService;
    
    /**
     * Solver class for the tasks of Day 4 of the 2024 Advent of Code.
     * 
     * @param wordsearchService The wordsearch service used to solve wordsearches.
     */
    public DayFourSolver(WordsearchService wordsearchService) {
        this.wordsearchService = wordsearchService;
    }

    /**
     * Solve the first task of Day 4 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    public String taskOne() {
        final Wordsearch wordsearch = Wordsearch.of(inputLines);

        return String.valueOf(wordsearchService.countInstancesOfXmas(wordsearch));
    }

    /**
     * Solve the second task of Day 4 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    public String taskTwo() {
        final Wordsearch wordsearch = Wordsearch.of(inputLines);

        return String.valueOf(wordsearchService.countInstancesOfMasX(wordsearch));
    }
}
