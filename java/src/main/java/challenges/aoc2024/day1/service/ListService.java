package challenges.aoc2024.day1.service;

import java.util.Collections;

import challenges.aoc2024.day1.model.ListLinePair;
import challenges.aoc2024.day1.model.LocationLists;

/**
 * Service for performing list calculations.
 */
public class ListService {

    public ListService() {
        // Empty constructor for dependency injection
    }

    /**
     * Calculate the total distance between the two teams' location lists.
     * 
     * @param locationLists The two teams' location lists.
     * 
     * @return The total distance between the lists.
     */
    public Integer calculateTotalListDistance(LocationLists locationLists) {
        
        return locationLists.getLinePairs().stream()
                    .map(pair -> Math.abs(pair.getLeftValue() - pair.getRightValue()))
                    .mapToInt(Integer::intValue)
                    .sum();
    }

    /**
     * Calculate the total similarity score between the two teams' location lists.
     * 
     * @param locationLists The two teams' location lists.
     * 
     * @return The total similarity score between the lists.
     */
    public Integer calculateTotalSimilarityScore(LocationLists locationLists) {

        return locationLists.getLinePairs().stream()
                    .map(ListLinePair::getLeftValue)
                    .map(leftValue -> leftValue * Collections.frequency(locationLists.getLinePairs().stream()
                        .map(ListLinePair::getRightValue)
                        .toList(), leftValue))
                    .mapToInt(Integer::intValue)
                    .sum();
    }
}
