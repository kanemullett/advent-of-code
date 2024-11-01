package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdventUtils.class);

    private AdventUtils() {
        // Prevent instantiation of utility class
    }

    public static List<String> parseInput(Integer year, Integer day) {
        final File file = new File(String.format("./src/main/resources/aoc-%s/day-%s.txt", year, day));
        final List<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Input file not found: {}", file.getAbsolutePath());
        }

        return lines;
    }
}
