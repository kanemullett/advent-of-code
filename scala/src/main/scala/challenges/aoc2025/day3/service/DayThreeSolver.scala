package challenges.aoc2025.day3.service

import challenges.aoc2025.day3.model.BatteryBank
import service.DaySolver
import util.AdventUtils

class DayThreeSolver(batteryService: BatteryService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2025, 3)

  override def taskOne(): String = {
    
    val banks: List[BatteryBank] = inputLines
      .map(BatteryBank.of)
    
    batteryService.calculateTotalJoltage(banks, 2).toString
  }

  override def taskTwo(): String = {

    val banks: List[BatteryBank] = inputLines
      .map(BatteryBank.of)

    batteryService.calculateTotalJoltage(banks, 12).toString
  }
}
