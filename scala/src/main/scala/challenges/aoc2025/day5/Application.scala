package challenges.aoc2025.day5

import _root_.service.TaskSolver
import challenges.aoc2025.day5.service.{DayFiveSolver, IngredientService}

object Application {
  def main(args: Array[String]): Unit = {
    val solver: TaskSolver = TaskSolver(DayFiveSolver(IngredientService()))
    solver.solveTasks()
  }
}
