package challenges.aoc2024.day1.service

import challenges.aoc2024.day1.model.LocationLists
import service.DaySolver
import util.AdventUtils

class DayOneSolver(listService: ListService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2024, 1)

  override def taskOne(): String = {
    val locationLists: LocationLists = LocationLists.of(inputLines)

    listService.calculateTotalListDistance(locationLists).toString
  }

  override def taskTwo(): String = {
    val locationLists: LocationLists = LocationLists.of(inputLines)

    listService.calculateTotalSimilarityScore(locationLists).toString
  }
}
