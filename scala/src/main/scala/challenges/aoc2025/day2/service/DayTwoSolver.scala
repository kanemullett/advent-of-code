package challenges.aoc2025.day2.service

import challenges.aoc2025.day2.model.IdRange
import service.DaySolver
import util.AdventUtils

class DayTwoSolver(validationService: IdValidationService) extends DaySolver {
  private val inputLine: String = AdventUtils.parseInput(2025, 2).head

  override def taskOne(): String = {
    val ranges: List[IdRange] = inputLine.split(",")
      .map(IdRange.of)
      .toList
    
    validationService.calculateInvalidIdTotal(ranges).toString
  }

  override def taskTwo(): String = ???
}
