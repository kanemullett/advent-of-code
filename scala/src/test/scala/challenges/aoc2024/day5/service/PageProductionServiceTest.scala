package challenges.aoc2024.day5.service

import challenges.aoc2024.day5.model.{PageOrderingRule, ProductionUpdate}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class PageProductionServiceTest extends AnyFunSuite with BeforeAndAfter {

  var pageProductionService: PageProductionService = _

  before {
    pageProductionService = PageProductionService()
  }

  test("should calculate total of middle number in correct updates") {
    // Given
    val pageOrderingRules: List[PageOrderingRule] = List(
      PageOrderingRule.of("47|53"),
      PageOrderingRule.of("97|13"),
      PageOrderingRule.of("97|61"),
      PageOrderingRule.of("97|47"),
      PageOrderingRule.of("75|29"),
      PageOrderingRule.of("61|13"),
      PageOrderingRule.of("75|53"),
      PageOrderingRule.of("29|13"),
      PageOrderingRule.of("97|29"),
      PageOrderingRule.of("53|29"),
      PageOrderingRule.of("61|53"),
      PageOrderingRule.of("97|53"),
      PageOrderingRule.of("61|29"),
      PageOrderingRule.of("47|13"),
      PageOrderingRule.of("75|47"),
      PageOrderingRule.of("97|75"),
      PageOrderingRule.of("47|61"),
      PageOrderingRule.of("75|61"),
      PageOrderingRule.of("47|29"),
      PageOrderingRule.of("75|13"),
      PageOrderingRule.of("53|13")
    )

    val productionUpdates: List[ProductionUpdate] = List(
      ProductionUpdate.of("75,47,61,53,29"),
      ProductionUpdate.of("97,61,53,29,13"),
      ProductionUpdate.of("75,29,13"),
      ProductionUpdate.of("75,97,47,61,53"),
      ProductionUpdate.of("61,13,29"),
      ProductionUpdate.of("97,13,75,29,47")
    )

    // When
    val total: Int = pageProductionService.calculateTotalOfMiddleNumberInCorrectUpdates(pageOrderingRules, productionUpdates)

    // Then
    assert(143 == total)
  }

  test("should calculate total of middle number in reordered incorrect updates") {
    // Given
    val pageOrderingRules: List[PageOrderingRule] = List(
      PageOrderingRule.of("47|53"),
      PageOrderingRule.of("97|13"),
      PageOrderingRule.of("97|61"),
      PageOrderingRule.of("97|47"),
      PageOrderingRule.of("75|29"),
      PageOrderingRule.of("61|13"),
      PageOrderingRule.of("75|53"),
      PageOrderingRule.of("29|13"),
      PageOrderingRule.of("97|29"),
      PageOrderingRule.of("53|29"),
      PageOrderingRule.of("61|53"),
      PageOrderingRule.of("97|53"),
      PageOrderingRule.of("61|29"),
      PageOrderingRule.of("47|13"),
      PageOrderingRule.of("75|47"),
      PageOrderingRule.of("97|75"),
      PageOrderingRule.of("47|61"),
      PageOrderingRule.of("75|61"),
      PageOrderingRule.of("47|29"),
      PageOrderingRule.of("75|13"),
      PageOrderingRule.of("53|13")
    )

    val productionUpdates: List[ProductionUpdate] = List(
      ProductionUpdate.of("75,47,61,53,29"),
      ProductionUpdate.of("97,61,53,29,13"),
      ProductionUpdate.of("75,29,13"),
      ProductionUpdate.of("75,97,47,61,53"),
      ProductionUpdate.of("61,13,29"),
      ProductionUpdate.of("97,13,75,29,47")
    )

    // When
    val total: Int = pageProductionService.calculateTotalOfMiddleNumberInReorderedIncorrectUpdates(pageOrderingRules, productionUpdates)

    // Then
    assert(123 == total)
  }
}
