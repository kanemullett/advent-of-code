package challenges.aoc2024.day5.function

import challenges.aoc2024.day5.model.{PageOrderingRule, ProductionUpdate}

class PageOrderingFunction(rules: List[PageOrderingRule]) extends (ProductionUpdate => ProductionUpdate) {

  override def apply(update: ProductionUpdate): ProductionUpdate = {
    val pages: List[Int] = update.pages
      .sorted(new PageOrderingComparator(rules))
    
    ProductionUpdate(pages)
  }
}
