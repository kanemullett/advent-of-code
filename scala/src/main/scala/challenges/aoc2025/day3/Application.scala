package challenges.aoc2025.day3

import _root_.service.TaskSolver
import challenges.aoc2025.day3.service.{BatteryService, DayThreeSolver}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayThreeSolver(BatteryService()))
    solver.solveTasks()
  }
}
