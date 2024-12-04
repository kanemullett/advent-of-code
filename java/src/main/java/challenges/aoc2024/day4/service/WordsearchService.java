package challenges.aoc2024.day4.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import challenges.aoc2024.day4.model.CoordinatePair;
import challenges.aoc2024.day4.model.Wordsearch;
import challenges.aoc2024.day4.model.WordsearchLetter;

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
    
    public WordsearchService() {

    }

    public Integer countInstancesOfXmas(Wordsearch wordsearch) {

        return wordsearch.getLetters().stream()
            .filter(letter -> "X".equals(letter.getLetter()))
            .map(xLetter -> VECTORS.stream()
                .map(vector -> nextThreeCharacters(wordsearch.getLetters(), xLetter.getPostion(), vector))
                .toList())
            .flatMap(List::stream)
            .filter("MAS"::equals)
            .toList().size();
    }

    private boolean areEqual(CoordinatePair one, CoordinatePair two) {
        return Objects.equals(one.getXCoordinate(), two.getXCoordinate()) && Objects.equals(one.getYCoordinate(), two.getYCoordinate());
    }

    private String nextThreeCharacters(List<WordsearchLetter> letters, CoordinatePair start, CoordinatePair vectorMovement) {
        final List<String> characters = IntStream.range(1, 4)
            .mapToObj(i -> letters.stream()
                .filter(letter -> areEqual(letter.getPostion(), CoordinatePair.of(start.getXCoordinate() + (vectorMovement.getXCoordinate() * i), start.getYCoordinate() + (vectorMovement.getYCoordinate() * i))))
                .toList())
            .flatMap(List::stream)
            .map(WordsearchLetter::getLetter)
            .toList();

        return String.join("", characters);
    }
}
