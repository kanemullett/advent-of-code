package challenges.aoc2025.day5.function

import challenges.aoc2025.day5.model.IngredientIdRange

class IngredientFreshnessPredicate(freshRanges: List[IngredientIdRange]) extends (Long => Boolean) {

  override def apply(ingredientId: Long): Boolean = {

    freshRanges.exists(range => ingredientId >= range.firstId && ingredientId <= range.lastId)
  }
}
