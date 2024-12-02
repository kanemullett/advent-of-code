package challenges.aoc2024.day2;

import challenges.aoc2024.day2.service.DayTwoSolver;
import challenges.aoc2024.day2.service.ReactorReportService;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayTwoSolver(new ReactorReportService()));
        solver.solveTasks();
    }
}
