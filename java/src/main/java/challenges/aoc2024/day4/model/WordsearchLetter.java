package challenges.aoc2024.day4.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface WordsearchLetter {
    
    String getLetter();

    CoordinatePair getPostion();

    static WordsearchLetter of(String letter, CoordinatePair position) {

        return ImmutableWordsearchLetter.builder()
            .letter(letter)
            .postion(position)
            .build();
    }
}
