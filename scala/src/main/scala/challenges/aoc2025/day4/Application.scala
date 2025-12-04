package challenges.aoc2025.day4

import _root_.service.TaskSolver
import challenges.aoc2025.day4.service.{DayFourSolver, ForkliftService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayFourSolver(ForkliftService()))
    solver.solveTasks()
  }
}
