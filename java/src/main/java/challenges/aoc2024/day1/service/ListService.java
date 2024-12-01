package challenges.aoc2024.day1.service;

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
}
