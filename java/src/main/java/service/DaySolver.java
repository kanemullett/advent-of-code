package service;

/**
 * Interface for solving tasks for a specific day.
 */
public interface DaySolver {

    /**
     * Solve the first task for the day.
     *
     * @return The solution to the first task.
     */
    String taskOne();

    /**
     * Solve the second task for the day.
     *
     * @return The solution to the second task.
     */
    String taskTwo();
}
