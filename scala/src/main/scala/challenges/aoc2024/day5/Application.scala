package challenges.aoc2024.day5

import _root_.service.TaskSolver
import challenges.aoc2024.day5.service.{DayFiveSolver, PageProductionService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayFiveSolver(PageProductionService()))
    solver.solveTasks()
  }
}
