package challenges.aoc2024.day6;

import challenges.aoc2024.day6.service.DaySixSolver;
import challenges.aoc2024.day6.service.LabService;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DaySixSolver(new LabService()));
        solver.solveTasks();
    }
}
