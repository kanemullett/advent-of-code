package challenges.aoc2024.day4;

import challenges.aoc2024.day4.service.DayFourSolver;
import challenges.aoc2024.day4.service.WordsearchService;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayFourSolver(new WordsearchService()));
        solver.solveTasks();
    }
}
