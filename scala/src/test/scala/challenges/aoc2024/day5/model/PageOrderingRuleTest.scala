package challenges.aoc2024.day5.model

import org.scalatest.funsuite.AnyFunSuite

class PageOrderingRuleTest extends AnyFunSuite {

  test("should build PageOrderingRule object from string") {
    // When
    val pageOrderingRule: PageOrderingRule = PageOrderingRule.of("23|47")

    // Then
    assert(pageOrderingRule.isInstanceOf[PageOrderingRule])
    assert(23 == pageOrderingRule.beforeNumber)
    assert(47 == pageOrderingRule.afterNumber)
  }
}
