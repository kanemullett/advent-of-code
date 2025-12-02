package challenges.aoc2025.day1

import _root_.service.TaskSolver
import challenges.aoc2025.day1.service.{DayOneSolver, SafeService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayOneSolver(SafeService()))
    solver.solveTasks()
  }
}
