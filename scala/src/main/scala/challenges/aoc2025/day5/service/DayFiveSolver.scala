package challenges.aoc2025.day5.service

import challenges.aoc2025.day5.model.IngredientIdRange
import service.DaySolver
import util.AdventUtils

class DayFiveSolver(ingredientService: IngredientService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2025, 5)

  override def taskOne(): String = {
    
    val ranges: List[IngredientIdRange] = inputLines
      .filter(_.contains("-"))
      .map(IngredientIdRange.of)
    
    val ingredientIds: List[Long] = inputLines
      .filterNot(_.contains("-"))
      .filter(_.nonEmpty)
      .map(_.toLong)
    
    ingredientService.countFreshIngredients(ranges, ingredientIds).toString
  }

  override def taskTwo(): String = ???
}
