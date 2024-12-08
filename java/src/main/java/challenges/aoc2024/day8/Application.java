package challenges.aoc2024.day8;

import challenges.aoc2024.day8.service.AntennaService;
import challenges.aoc2024.day8.service.DayEightSolver;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayEightSolver(new AntennaService()));
        solver.solveTasks();
    }
}
