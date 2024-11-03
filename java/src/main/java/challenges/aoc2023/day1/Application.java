package challenges.aoc2023.day1;

import challenges.aoc2023.day1.service.CalibrationService;
import challenges.aoc2023.day1.service.DayOneSolver;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayOneSolver(new CalibrationService()));
        solver.solveTasks();
    }
}
