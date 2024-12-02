package challenges.aoc2024.day2.function;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import challenges.aoc2024.day2.model.ReactorReport;
import challenges.aoc2024.day2.model.type.GradientDirection;

public class ReactorSafetyPredicate implements Predicate<ReactorReport> {
    
    @Override
    public boolean test(ReactorReport reactorReport) {

        final GradientDirection direction = determineGradientDirection(reactorReport.getLevels());

        if (direction == null) {
            return false;
        }

        return IntStream.range(0, reactorReport.getLevels().size() - 1)
            .filter(i -> isSafeIncreaseOrDecrease(direction, reactorReport.getLevels().get(i), reactorReport.getLevels().get(i + 1)))
            .toArray().length + 1 == reactorReport.getLevels().size();
    }

    private GradientDirection determineGradientDirection(List<Integer> levels) {
        if (levels.stream().distinct().collect(Collectors.toList()).size() != levels.size()) {
            return null;
        }

        final List<GradientDirection> changes = IntStream.range(0, levels.size() - 1)
            .mapToObj(i -> levels.get(i) > levels.get(i + 1) ? GradientDirection.DECREASE : GradientDirection.INCREASE)
            .toList();

        if (changes.stream().distinct().collect(Collectors.toList()).size() > 1) {
            return null;
        }

        return changes.get(0);
    }

    private boolean isSafeIncreaseOrDecrease(GradientDirection direction, Integer startLevel, Integer nextLevel) {
        return (direction == GradientDirection.INCREASE && startLevel < nextLevel && startLevel + 3 >= nextLevel)
            || (direction == GradientDirection.DECREASE && startLevel > nextLevel && startLevel - 3 <= nextLevel);
    }
}
