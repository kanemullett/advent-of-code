package challenges.aoc2024.day2.function;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import challenges.aoc2024.day2.model.ReactorReport;
import challenges.aoc2024.day2.model.type.GradientDirection;

/**
 * Predicate class to determine whether a reactor's reported levels are safe.
 */
public class ReactorSafetyPredicate implements Predicate<ReactorReport> {
    private boolean isProblemDampenerActive;

    /**
     * Predicate class to determine whether a reactor's reported levels are safe.
     * 
     * @param isProblemDampenerActive True if the reactor has an active problem dampener.
     */
    public ReactorSafetyPredicate(boolean isProblemDampenerActive) {
        this.isProblemDampenerActive = isProblemDampenerActive;
    }
    
    /**
     * Apply predicate logic to determine whether a reactor's reported levels are safe.
     * 
     * @param reactorReport The reactor report whose levels are to be checked.
     * 
     * @return True if the reactor's reported levels are safe.
     */
    @Override
    public boolean test(ReactorReport reactorReport) {

        final boolean initiallySafe = isSafe(reactorReport.getLevels());

        if (!isProblemDampenerActive || initiallySafe) {
            return initiallySafe;
        }

        return !IntStream.range(0, reactorReport.getLevels().size())
            .mapToObj(indexToIgnore -> IntStream.range(0, reactorReport.getLevels().size())
                .filter(i -> i != indexToIgnore)
                .mapToObj(reactorReport.getLevels()::get)
                .collect(Collectors.toList()))
            .filter(this::isSafe)
            .toList().isEmpty();
    }

    /**
     * Determine whether a reactor's reported levels are safe.
     * 
     * @param levels The levels to be checked.
     * 
     * @return True if the reactor's reported levels are safe.
     */
    private boolean isSafe(List<Integer> levels) {
        final GradientDirection direction = determineGradientDirection(levels);

        if (direction == null) {
            return false;
        }

        return IntStream.range(0, levels.size() - 1)
            .filter(i -> isSafeIncreaseOrDecrease(direction, levels.get(i), levels.get(i + 1)))
            .toArray().length + 1 == levels.size();
    }

    /**
     * Determine the consistent gradient direction of the reactor's reported levels.
     * 
     * @param levels The reactor's reported levels.
     * 
     * @return The gradient direction; returns null if the gradient direction is inconsistent.
     */
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

    /**
     * Determine whether the increase/decrease of the reactor's reported level is within a safe scope.
     * 
     * @param direction The direction of the change in level.
     * @param startLevel The initial level.
     * @param nextLevel The level after the increase/decrease.
     * 
     * @return True if the increase/decrease in the reactor's reported level is safe.
     */
    private boolean isSafeIncreaseOrDecrease(GradientDirection direction, Integer startLevel, Integer nextLevel) {
        return (direction == GradientDirection.INCREASE && startLevel < nextLevel && startLevel + 3 >= nextLevel)
            || (direction == GradientDirection.DECREASE && startLevel > nextLevel && startLevel - 3 <= nextLevel);
    }
}
