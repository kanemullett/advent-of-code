package challenges.aoc2024.day4.model;

import java.util.List;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Wordsearch {
    
    List<WordsearchLetter> getLetters();

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
