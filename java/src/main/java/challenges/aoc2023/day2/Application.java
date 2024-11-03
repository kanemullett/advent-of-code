package challenges.aoc2023.day2;

import challenges.aoc2023.day2.service.DayTwoSolver;
import service.TaskSolver;

public class Application {
    public static void main(String[] args) {
        final TaskSolver solver = new TaskSolver(new DayTwoSolver());
        solver.solveTasks();
    }
}
