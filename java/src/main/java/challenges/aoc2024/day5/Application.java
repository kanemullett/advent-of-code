package challenges.aoc2024.day5;

import challenges.aoc2024.day5.service.DayFiveSolver;
import challenges.aoc2024.day5.service.PageProductionService;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayFiveSolver(new PageProductionService()));
        solver.solveTasks();
    }
}
