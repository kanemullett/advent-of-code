package challenges.aoc2025.day1.service

import challenges.aoc2025.day1.model.DialRotation
import service.DaySolver
import util.AdventUtils

class DayOneSolver(safeService: SafeService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2025, 1)

  override def taskOne(): String = {
    val rotations: List[DialRotation] = inputLines
      .map(DialRotation.of)
    
    safeService.decipherPassword(rotations, false).toString
  }

  override def taskTwo(): String = {
    val rotations: List[DialRotation] = inputLines
      .map(DialRotation.of)

    safeService.decipherPassword(rotations, true).toString
  }
}
