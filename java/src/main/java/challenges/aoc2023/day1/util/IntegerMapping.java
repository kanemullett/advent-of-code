package challenges.aoc2023.day1.util;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to map words to integers and vice versa.
 */
public class IntegerMapping {
    private static final List<String> INTEGERS = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final List<String> WORDS = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private static final Map<String, String> wordToIntegerLookup = new HashMap<>();

    /**
     * Build the lookup map from words to integers.
     */
    @PostConstruct
    public void buildLookup() {
        for (int i = 0; i < INTEGERS.size(); i++) {
            wordToIntegerLookup.put(WORDS.get(i), INTEGERS.get(i));
        }
    }

    /**
     * Retrieve the list of integers in numeric form.
     *
     * @return List of integers in numeric form.
     */
    public List<String> getIntegers() {
        return INTEGERS;
    }

    /**
     * Retrieve the list of integers in words.
     *
     * @return List of integers in words.
     */
    public List<String> getWords() {
        return WORDS;
    }

    /**
     * Retrieve the numeric form of an integer in word form.
     *
     * @param toConvert The integer in word form.
     *
     * @return The integer in numeric form.
     */
    public String asInteger(String toConvert) {
        return INTEGERS.contains(toConvert) ? toConvert : wordToIntegerLookup.get(toConvert);
    }
}
