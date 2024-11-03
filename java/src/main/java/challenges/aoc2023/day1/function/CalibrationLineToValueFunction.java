package challenges.aoc2023.day1.function;

import challenges.aoc2023.day1.model.ValuePosition;
import challenges.aoc2023.day1.util.IntegerMapping;
import org.apache.commons.collections4.ListUtils;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Function class to convert a calibration line into its calibration value.
 */
@SuppressWarnings("java:S4276") // Not a fan of returning a primitive int type.
public class CalibrationLineToValueFunction implements Function<String, Integer> {
    private final IntegerMapping integerMapping = new IntegerMapping();
    private final boolean textNumbersCountAsIntegers;

    /**
     * Function class to convert a calibration line into its calibration value.
     *
     * @param textNumbersCountAsIntegers True if numbers written in text count as number values.
     */
    public CalibrationLineToValueFunction(boolean textNumbersCountAsIntegers) {
        this.textNumbersCountAsIntegers = textNumbersCountAsIntegers;
        integerMapping.buildLookup();
    }

    /**
     * Apply function logic to convert a calibration line into its calibration value.
     *
     * @param calibrationLine the calibration line to convert.
     *
     * @return The calibration value produced by the calibration line.
     */
    public Integer apply(String calibrationLine) {
        final List<String> values = textNumbersCountAsIntegers ? ListUtils.union(integerMapping.getIntegers(), integerMapping.getWords()) : integerMapping.getIntegers();

        final List<String> integers = values.stream()
            .filter(calibrationLine::contains)
            .map(appears -> Stream.iterate(calibrationLine.indexOf(appears), i -> i >= 0, i -> calibrationLine.indexOf(appears, i + 1))
                .map(index -> ValuePosition.of(appears, index))
                .toList())
            .flatMap(List::stream)
            .sorted(Comparator.comparingInt(ValuePosition::getPosition))
            .map(ValuePosition::getValue)
            .map(integerMapping::asInteger)
            .toList();

        return Integer.parseInt(integers.get(0) + integers.get(integers.size() - 1));
    }
}
