package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskSolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskSolver.class);

    private final DaySolver taskSolutions;

    public TaskSolver(DaySolver taskSolutions) {
        this.taskSolutions = taskSolutions;
    }

    @SuppressWarnings("java:S2629") // Not great practice to spam logs, but I'm not building API for this.
    public void solveTasks() {
        LOGGER.info(String.format("Task 1 Solution: %s", taskSolutions.taskOne()));
        LOGGER.info(String.format("Task 2 Solution: %s", taskSolutions.taskTwo()));
    }
}
