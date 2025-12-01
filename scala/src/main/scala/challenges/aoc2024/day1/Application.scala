package challenges.aoc2024.day1

import _root_.service.TaskSolver
import challenges.aoc2024.day1.service.{DayOneSolver, ListService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayOneSolver(ListService()))
    solver.solveTasks()
  }
}
