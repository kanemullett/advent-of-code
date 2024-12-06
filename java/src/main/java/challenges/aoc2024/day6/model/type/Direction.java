package challenges.aoc2024.day6.model.type;

public enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT;

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
