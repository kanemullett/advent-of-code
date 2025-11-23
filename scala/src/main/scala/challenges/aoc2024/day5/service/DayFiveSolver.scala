package challenges.aoc2024.day5.service

import challenges.aoc2024.day5.model.{PageOrderingRule, ProductionUpdate}
import service.DaySolver
import util.AdventUtils

class DayFiveSolver(pageProductionService: PageProductionService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2024, 5)

  override def taskOne(): String = {

    val pageOrderingRules: List[PageOrderingRule] = inputLines
      .filter(_.contains("|"))
      .map(PageOrderingRule.of)

    val productionUpdates: List[ProductionUpdate] = inputLines
      .filter(_.nonEmpty)
      .filter(!_.contains("|"))
      .map(ProductionUpdate.of)

    pageProductionService.calculateTotalOfMiddleNumberInCorrectUpdates(pageOrderingRules, productionUpdates).toString
  }

  override def taskTwo(): String = {

    val pageOrderingRules: List[PageOrderingRule] = inputLines
      .filter(_.contains("|"))
      .map(PageOrderingRule.of)

    val productionUpdates: List[ProductionUpdate] = inputLines
      .filter(_.nonEmpty)
      .filter(!_.contains("|"))
      .map(ProductionUpdate.of)

    pageProductionService.calculateTotalOfMiddleNumberInReorderedIncorrectUpdates(pageOrderingRules, productionUpdates).toString
  }
}
