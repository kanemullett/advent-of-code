package challenges.aoc2025.day4.function

import challenges.aoc2025.day4.model.{PaperRoll, WarehouseSpace}

class PaperRollAccessibilityPredicate extends (List[WarehouseSpace] => Boolean) {

  override def apply(adjacent: List[WarehouseSpace]): Boolean = {

    adjacent.count(_.isInstanceOf[PaperRoll]) < 4
  }
}
