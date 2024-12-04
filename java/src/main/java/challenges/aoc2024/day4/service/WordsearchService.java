package challenges.aoc2024.day4.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import challenges.aoc2024.day4.model.CoordinatePair;
import challenges.aoc2024.day4.model.Wordsearch;
import challenges.aoc2024.day4.model.WordsearchLetter;

/**
 * Service for solving wordsearch challenges.
 */
public class WordsearchService {
    private static final List<CoordinatePair> VECTORS = List.of(
        CoordinatePair.of(-1, -1),
        CoordinatePair.of(0, -1),
        CoordinatePair.of(1, -1),
        CoordinatePair.of(-1, 0),
        CoordinatePair.of(1, 0),
        CoordinatePair.of(-1, 1),
        CoordinatePair.of(0, 1),
        CoordinatePair.of(1, 1)
    );

    private static final String MAS_STRING = "MAS";
    
    public WordsearchService() {
        // Empty constructor for dependency injection
    }

    /**
     * Count the total number of times the word 'XMAS' appears in the wordsearch.
     * 
     * @param wordsearch The wordsearch to solve.
     * 
     * @return The number of times 'XMAS' appears in the wordsearch.
     */
    public Integer countInstancesOfXmas(Wordsearch wordsearch) {

        return wordsearch.getLetters().stream()
            .filter(letter -> "X".equals(letter.getLetter()))
            .map(xLetter -> VECTORS.stream()
                .map(vector -> String.join("", nextThreeLetters(wordsearch.getLetters(), xLetter.getPostion(), vector, false).stream()
                    .map(WordsearchLetter::getLetter)
                    .toList()))
                .toList())
            .flatMap(List::stream)
            .filter(MAS_STRING::equals)
            .toList().size();
    }

    /**
     * Count the total number of times two 'MAS' terms intersect in an 'X' shape at their shared 'A' letter.
     * 
     * @param wordsearch The wordsearch to solve.
     * 
     * @return The number of times the 'X-MAS' shape appears in the wordsearch.
     */
    public Integer countInstancesOfMasX(Wordsearch wordsearch) {

        return wordsearch.getLetters().stream()
            .filter(letter -> "M".equals(letter.getLetter()))
            .map(mLetter -> VECTORS.stream()
                .filter(vec -> vec.getXCoordinate() != 0 && vec.getYCoordinate() != 0)
                .map(vector -> nextThreeLetters(wordsearch.getLetters(), mLetter.getPostion(), vector, true))
                .filter(characterSet -> MAS_STRING.equals(String.join("", characterSet.stream()
                    .map(WordsearchLetter::getLetter)
                    .toList())))
                .toList())
            .filter(vectorItem -> !vectorItem.isEmpty())
            .map(listList -> listList.stream()
                .map(subList -> subList.get(1))
                .toList())
            .flatMap(List::stream)
            .map(WordsearchLetter::getPostion)
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() == 2)
            .map(Map.Entry::getKey)
            .toList().size();
    }

    /**
     * Compare the values in two coordinate pair objects to determine if they represent the same position.
     * 
     * @param firstCoordinate The first coordinate pair.
     * @param secondCoordinate The second coordinate pair.
     * 
     * @return True if the coordinate pairs represent the same position.
     */
    private boolean areEqual(CoordinatePair firstCoordinate, CoordinatePair secondCoordinate) {
        return Objects.equals(firstCoordinate.getXCoordinate(), secondCoordinate.getXCoordinate()) 
            && Objects.equals(firstCoordinate.getYCoordinate(), secondCoordinate.getYCoordinate());
    }

    /**
     * Find the next three letters in a given direction, provided a movement vector and a starting position.
     * 
     * @param letters The letters from the wordsearch.
     * @param startPosition The initial position to apply the movement vector from.
     * @param movementVector The movement vector to apply to find the next three letters.
     * @param includeStart True if the letter at the start position should be included as one of the three letters.
     * 
     * @return The next three letters from the wordsearch.
     */
    private List<WordsearchLetter> nextThreeLetters(List<WordsearchLetter> letters, CoordinatePair startPosition, CoordinatePair movementVector, boolean includeStart) {
        final IntStream intStream = includeStart ? IntStream.range(0, 3) : IntStream.range(1, 4);

        return intStream
            .mapToObj(i -> letters.stream()
                .filter(letter -> areEqual(letter.getPostion(), CoordinatePair.of(startPosition.getXCoordinate() + (movementVector.getXCoordinate() * i), startPosition.getYCoordinate() + (movementVector.getYCoordinate() * i))))
                .toList())
            .flatMap(List::stream)
            .toList();
    }
}
