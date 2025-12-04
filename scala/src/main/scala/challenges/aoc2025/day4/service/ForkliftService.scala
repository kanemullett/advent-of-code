package challenges.aoc2025.day4.service

import challenges.aoc2025.day4.function.PaperRollAccessibilityPredicate
import challenges.aoc2025.day4.model.{PaperRoll, Warehouse}

class ForkliftService {

  def calculateTotalAccessiblePaperRolls(warehouse: Warehouse): Int = {

    warehouse.spaces
      .filter(_.isInstanceOf[PaperRoll])
      .map(_.adjacentLocations
        .map(adjacent => warehouse.spaces
          .find(_.location == adjacent)
          .get))
      .count(new PaperRollAccessibilityPredicate())
  }
}
