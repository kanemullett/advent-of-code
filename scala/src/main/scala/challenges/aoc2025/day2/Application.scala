package challenges.aoc2025.day2

import _root_.service.TaskSolver
import challenges.aoc2025.day2.service.{DayTwoSolver, IdValidationService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayTwoSolver(IdValidationService()))
    solver.solveTasks()
  }
}
