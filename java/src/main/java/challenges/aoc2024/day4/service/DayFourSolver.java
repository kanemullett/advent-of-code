package challenges.aoc2024.day4.service;

import java.util.List;

import challenges.aoc2024.day4.model.Wordsearch;
import service.DaySolver;
import util.AdventUtils;

public class DayFourSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 4);
    private final WordsearchService wordsearchService;
    
    public DayFourSolver(WordsearchService wordsearchService) {
        this.wordsearchService = wordsearchService;
    }

    public String taskOne() {
        final Wordsearch wordsearch = Wordsearch.of(inputLines);

        return String.valueOf(wordsearchService.countInstancesOfXmas(wordsearch));
    }

    public String taskTwo() {
        return null;
    }
}
