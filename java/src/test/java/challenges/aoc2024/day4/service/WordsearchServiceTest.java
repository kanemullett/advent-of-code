package challenges.aoc2024.day4.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day4.model.Wordsearch;

class WordsearchServiceTest {
    private WordsearchService wordsearchService;

    @BeforeEach
    void setUp() {
        wordsearchService = new WordsearchService();
    }

    @Test
    void testCountInstancesOfXmas() {
        // Given
        final List<String> wordsearchRows = List.of(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        );

        final Wordsearch wordsearch = Wordsearch.of(wordsearchRows);

        // When
        final Integer xmasCount = wordsearchService.countInstancesOfXmas(wordsearch);

        // Then
        assertEquals(18, xmasCount);
    }
}
