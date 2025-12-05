package challenges.aoc2025.day5.service

import challenges.aoc2025.day5.function.IngredientFreshnessPredicate
import challenges.aoc2025.day5.model.IngredientIdRange

class IngredientService {

  def countFreshIngredients(freshRanges: List[IngredientIdRange], ingredientIds: List[Long]): Int = {
    
    ingredientIds
      .count(new IngredientFreshnessPredicate(freshRanges))
  }
}
