package challenges.aoc2024.day2

import _root_.service.TaskSolver
import challenges.aoc2024.day2.service.{DayTwoSolver, ReactorReportService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayTwoSolver(ReactorReportService()))
    solver.solveTasks()
  }
}
