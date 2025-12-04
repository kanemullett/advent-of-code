package challenges.aoc2025.day4.service

import challenges.aoc2025.day4.model.Warehouse
import service.DaySolver
import util.AdventUtils

class DayFourSolver(forkliftService: ForkliftService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2025, 4)

  override def taskOne(): String = {
    val warehouse: Warehouse = Warehouse.of(inputLines)
    
    forkliftService.calculateTotalAccessiblePaperRolls(warehouse).toString
  }

  override def taskTwo(): String = ???
}
