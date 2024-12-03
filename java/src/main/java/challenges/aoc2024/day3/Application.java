package challenges.aoc2024.day3;

import challenges.aoc2024.day3.service.DayThreeSolver;
import challenges.aoc2024.day3.service.ProgramService;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayThreeSolver(new ProgramService()));
        solver.solveTasks();
    }
}
