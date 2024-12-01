package challenges.aoc2024.day1;

import challenges.aoc2024.day1.service.DayOneSolver;
import challenges.aoc2024.day1.service.ListService;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayOneSolver(new ListService()));
        solver.solveTasks();
    }
}
