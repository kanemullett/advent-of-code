package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TaskSolver class to solve the tasks for a given day.
 */
public class TaskSolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskSolver.class);

    private final DaySolver daySolver;

    /**
     * TaskSolver class to solve the tasks for a given day.
     *
     * @param daySolver The day solver class to use to solve the tasks.
     */
    public TaskSolver(DaySolver daySolver) {
        this.daySolver = daySolver;
    }

    /**
     * Solve the tasks for the given day and log out their solutions.
     */
    @SuppressWarnings("java:S2629") // Not great practice to spam logs, but I'm not building API for this.
    public void solveTasks() {
        LOGGER.info(String.format("Task 1 Solution: %s", daySolver.taskOne()));
        LOGGER.info(String.format("Task 2 Solution: %s", daySolver.taskTwo()));
    }
}
