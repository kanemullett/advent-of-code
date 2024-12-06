package challenges.aoc2024.day4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.CoordinatePair;

class WordsearchTest {
    
    @Test
    void shouldBuildWordsearchObjectFromRows() {
        // Given
        final List<String> rows = List.of("HELLO", "THERE");

        // When
        final Wordsearch wordsearch = Wordsearch.of(rows);

        // Then
        assertEquals(ImmutableWordsearch.class, wordsearch.getClass());
        assertEquals(10, wordsearch.getLetters().size());
        
        final WordsearchLetter letterH = wordsearch.getLetters().get(0);
        assertEquals("H", letterH.getLetter());
        assertEquals(CoordinatePair.of(0, 0), letterH.getPostion());

        final WordsearchLetter lastE = wordsearch.getLetters().get(9);
        assertEquals("E", lastE.getLetter());
        assertEquals(CoordinatePair.of(4, 1), lastE.getPostion());
    }
}
