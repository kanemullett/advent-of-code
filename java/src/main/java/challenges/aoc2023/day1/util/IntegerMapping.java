package challenges.aoc2023.day1.util;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerMapping {
    private static final List<String> INTEGERS = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final List<String> WORDS = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private static final Map<String, String> wordToIntegerLookup = new HashMap<>();

    @PostConstruct
    public void buildLookup() {
        for (int i = 0; i < INTEGERS.size(); i++) {
            wordToIntegerLookup.put(WORDS.get(i), INTEGERS.get(i));
        }
    }

    public List<String> getIntegers() {
        return INTEGERS;
    }

    public List<String> getWords() {
        return WORDS;
    }

    public String asInteger(String toConvert) {
        return INTEGERS.contains(toConvert) ? toConvert : wordToIntegerLookup.get(toConvert);
    }
}
