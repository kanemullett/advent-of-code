package challenges.aoc2024.day4

import _root_.service.TaskSolver
import challenges.aoc2024.day4.service.{DayFourSolver, WordsearchService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayFourSolver(WordsearchService()))
    solver.solveTasks()
  }
}
