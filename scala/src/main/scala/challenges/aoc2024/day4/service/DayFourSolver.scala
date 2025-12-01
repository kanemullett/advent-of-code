package challenges.aoc2024.day4.service

import challenges.aoc2024.day4.model.Wordsearch
import service.DaySolver
import util.AdventUtils

class DayFourSolver(wordsearchService: WordsearchService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2024, 4)

  override def taskOne(): String = {
    val wordsearch: Wordsearch = Wordsearch.of(inputLines)

    wordsearchService.countInstancesOfXmas(wordsearch).toString
  }

  override def taskTwo(): String = {
    val wordsearch: Wordsearch = Wordsearch.of(inputLines)
    
    wordsearchService.countInstancesOfMasX(wordsearch).toString
  }
}
