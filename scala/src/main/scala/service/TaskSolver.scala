package service

import org.slf4j.LoggerFactory

class TaskSolver(daySolver: DaySolver) {
  private val logger = LoggerFactory.getLogger(getClass)

  def solveTasks(): Unit = {
    println(s"Task 1 Solution: ${daySolver.taskOne()}")
    println(s"Task 2 Solution: ${daySolver.taskTwo()}")
  }
}
