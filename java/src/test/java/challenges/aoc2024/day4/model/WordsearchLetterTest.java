package challenges.aoc2024.day4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WordsearchLetterTest {

    @Test
    void shouldBuildWordsearchLetterObjectFromLetterAndPosition() {
        // When
        final WordsearchLetter letter = WordsearchLetter.of("k", CoordinatePair.of(2, 3));

        // Then
        assertEquals(ImmutableWordsearchLetter.class, letter.getClass());
        assertEquals("k", letter.getLetter());
        assertEquals(CoordinatePair.of(2, 3), letter.getPostion());
    }
}
