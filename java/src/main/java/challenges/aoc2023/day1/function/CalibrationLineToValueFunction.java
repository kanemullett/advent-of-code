package challenges.aoc2023.day1.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@SuppressWarnings("java:S4276") // Not a fan of returning a primitive int type.
public class CalibrationLineToValueFunction implements Function<String, Integer> {

    public Integer apply(String calibrationLine) {
        final List<String> integers = Arrays.stream(calibrationLine.split(""))
            .filter(this::isInteger)
            .toList();

        return Integer.parseInt(integers.get(0) + integers.get(integers.size() - 1));
    }

    private boolean isInteger(String s) {
        return s.matches("\\d+");
    }
}
