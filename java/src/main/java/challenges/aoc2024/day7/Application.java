package challenges.aoc2024.day7;

import challenges.aoc2024.day7.service.CalibrationService;
import challenges.aoc2024.day7.service.DaySevenSolver;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DaySevenSolver(new CalibrationService()));
        solver.solveTasks();
    }
}
