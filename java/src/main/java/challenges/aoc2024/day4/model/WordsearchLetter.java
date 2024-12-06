package challenges.aoc2024.day4.model;

import org.immutables.value.Value.Immutable;

import model.CoordinatePair;

/**
 * WordsearchLetter object containing a letter from the wordsearch and its position.
 */
@Immutable
public interface WordsearchLetter {
    
    /**
     * The letter from the wordsearch.
     * 
     * @return The letter.
     */
    String getLetter();

    /**
     * The position of the letter within the wordsearch.
     * 
     * @return The position of the letter.
     */
    CoordinatePair getPostion();

    /**
     * Build a WordsearchLetter object from a letter and its position within the wordsearch.
     * 
     * @param letter The letter from the wordsearch.
     * @param position The position of the letter within the wordsearch.
     * 
     * @return The WordsearchLetter object.
     */
    static WordsearchLetter of(String letter, CoordinatePair position) {

        return ImmutableWordsearchLetter.builder()
            .letter(letter)
            .postion(position)
            .build();
    }
}
