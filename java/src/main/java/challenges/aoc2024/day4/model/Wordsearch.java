package challenges.aoc2024.day4.model;

import java.util.List;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

/**
 * Wordsearch object containing all letters.
 */
@Immutable
public interface Wordsearch {
    
    /**
     * The letters within the wordsearch.
     * 
     * @return The letters.
     */
    List<WordsearchLetter> getLetters();

    /**
     * Build a Wordsearch object from a list of its rows.
     * 
     * @param wordsearchRows The rows of the wordsearch in string format.
     * 
     * @return The Wordsearch object.
     */
    static Wordsearch of(List<String> wordsearchRows) {

        return ImmutableWordsearch.builder()
            .letters(wordsearchRows.stream()
                .map(row -> IntStream.range(0, row.split("").length)
                    .mapToObj(i -> WordsearchLetter.of(row.split("")[i], CoordinatePair.of(i, wordsearchRows.indexOf(row))))
                    .toList())
                .flatMap(List::stream)
                .toList())
            .build();
    }
}
