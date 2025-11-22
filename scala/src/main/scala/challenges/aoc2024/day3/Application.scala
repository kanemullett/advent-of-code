package challenges.aoc2024.day3

import _root_.service.TaskSolver
import challenges.aoc2024.day3.service.{DayThreeSolver, ProgramService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayThreeSolver(ProgramService()))
    solver.solveTasks()
  }
}
