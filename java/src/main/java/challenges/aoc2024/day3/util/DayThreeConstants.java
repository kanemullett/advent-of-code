package challenges.aoc2024.day3.util;

import java.util.regex.Pattern;

public class DayThreeConstants {
    
    private DayThreeConstants() {

    }

    public static final Pattern MULTIPLICATION_INSTRUCTION_PATTERN = Pattern.compile("mul\\((-?\\d+),(-?\\d+)\\)");
}
