package challenges.aoc2024.day1.service;

import java.util.Collections;

import challenges.aoc2024.day1.model.ListLinePair;
import challenges.aoc2024.day1.model.LocationList;

public class ListService {

    public ListService() {
        // Empty constructor for dependency injection
    }

    public Integer calculateTotalListDistance(LocationList locationList) {
        
        return locationList.getLinePairs().stream()
                    .map(pair -> Math.abs(pair.getLeftValue() - pair.getRightValue()))
                    .mapToInt(Integer::intValue)
                    .sum();
    }

    public Integer calculateTotalSimilarityScore(LocationList locationList) {

        return locationList.getLinePairs().stream()
                    .map(ListLinePair::getLeftValue)
                    .map(leftValue -> leftValue * Collections.frequency(locationList.getLinePairs().stream()
                        .map(ListLinePair::getRightValue)
                        .toList(), leftValue))
                    .mapToInt(Integer::intValue)
                    .sum();
    }
}
