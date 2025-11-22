package challenges.aoc2024.day3.service

import service.DaySolver
import util.AdventUtils

class DayThreeSolver(programService: ProgramService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2024, 3)

  override def taskOne(): String = {
    val rawMemory: String = inputLines.mkString("")

    programService.calculateTotalOfMultiplicationInstructions(rawMemory, false).toString
  }

  override def taskTwo(): String = {
    val rawMemory: String = inputLines.mkString("")

    programService.calculateTotalOfMultiplicationInstructions(rawMemory, true).toString
  }
}
