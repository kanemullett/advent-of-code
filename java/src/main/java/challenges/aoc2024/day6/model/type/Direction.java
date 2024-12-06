package challenges.aoc2024.day6.model.type;

/**
 * Enum class containing the four possible directions the lab guard could be facing.
 */
public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    /**
     * Convert an arrow direction string into into corresponding direction enum value.
     * 
     * @param directionString The direction string.
     * 
     * @return The direction enum value.
     */
    public static Direction of(String directionString) {
        
        return switch (directionString) {
            case "^" -> UP;
            case ">" -> RIGHT;
            case "v" -> DOWN;
            case "<" -> LEFT;
            default -> throw new IllegalArgumentException();
        };
    }
}
