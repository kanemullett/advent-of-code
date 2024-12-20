package challenges.aoc2024.day3.util;

import java.util.regex.Pattern;

/**
 * Class for storing common constants.
 */
public class DayThreeConstants {
    
    private DayThreeConstants() {

    }

    public static final Pattern MULTIPLICATION_INSTRUCTION_PATTERN = Pattern.compile("mul\\((-?\\d+),(-?\\d+)\\)");
    public static final Pattern DO_DONT_SECTION_PATTERN = Pattern.compile("(?<=do\\(\\))(.*?)(?=don't\\(\\))");
}
