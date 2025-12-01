package challenges.aoc2024.day5.function

import challenges.aoc2024.day5.model.{PageOrderingRule, ProductionUpdate}

class CorrectlyOrderedPagesPredicate(pageOrderingRules: List[PageOrderingRule]) extends (ProductionUpdate => Boolean) {

  override def apply(productionUpdate: ProductionUpdate): Boolean = {

    pageOrderingRules.forall(rule => satisfiesRule(productionUpdate, rule))
  }

  private def satisfiesRule(update: ProductionUpdate, rule: PageOrderingRule): Boolean = {

    if update.pages.contains(rule.beforeNumber) && update.pages.contains(rule.afterNumber) then
      update.pages.indexOf(rule.beforeNumber) < update.pages.indexOf(rule.afterNumber)
    else
      true
  }
}
