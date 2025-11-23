package challenges.aoc2024.day5.function

import challenges.aoc2024.day5.model.PageOrderingRule

class PageOrderingComparator(rules: List[PageOrderingRule]) extends Ordering[Int] {

  override def compare(firstPage: Int, secondPage: Int): Int = {
    try
      val relevantRule: PageOrderingRule = rules
        .filter(rule => isRelevantRule(rule, firstPage, secondPage))
        .head

      if firstPage == relevantRule.beforeNumber then -1 else 1

    catch
      case e: NoSuchElementException => 0
  }

  private def isRelevantRule(rule: PageOrderingRule, firstPage: Int, secondPage: Int): Boolean = {
    (rule.beforeNumber == firstPage && rule.afterNumber == secondPage)
    || (rule.beforeNumber == secondPage && rule.afterNumber == firstPage)
  }
}
