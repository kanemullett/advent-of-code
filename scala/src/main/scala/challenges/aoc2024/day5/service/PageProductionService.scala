package challenges.aoc2024.day5.service

import challenges.aoc2024.day5.function.{CorrectlyOrderedPagesPredicate, PageOrderingFunction}
import challenges.aoc2024.day5.model.{PageOrderingRule, ProductionUpdate}

class PageProductionService {

  def calculateTotalOfMiddleNumberInCorrectUpdates(orderingRules: List[PageOrderingRule], productionUpdates: List[ProductionUpdate]): Int = {

    productionUpdates
      .filter(new CorrectlyOrderedPagesPredicate(orderingRules))
      .map(update => update.pages(update.pages.size / 2))
      .sum
  }

  def calculateTotalOfMiddleNumberInReorderedIncorrectUpdates(orderingRules: List[PageOrderingRule], productionUpdates: List[ProductionUpdate]): Int = {

    productionUpdates
      .filter(update => !new CorrectlyOrderedPagesPredicate(orderingRules).apply(update))
      .map(new PageOrderingFunction(orderingRules))
      .map(update => update.pages(update.pages.size / 2))
      .sum
  }
}
