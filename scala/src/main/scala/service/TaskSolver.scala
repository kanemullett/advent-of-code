package service

class TaskSolver(daySolver: DaySolver) {

  def solveTasks(): Unit = {
    println(s"Task 1 Solution: ${daySolver.taskOne()}")
    println(s"Task 2 Solution: ${daySolver.taskTwo()}")
  }
}
