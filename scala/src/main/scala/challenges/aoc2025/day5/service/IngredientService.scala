package challenges.aoc2025.day5.service

import challenges.aoc2025.day5.function.IngredientFreshnessPredicate
import challenges.aoc2025.day5.model.IngredientIdRange

class IngredientService {

  def countFreshIngredients(freshRanges: List[IngredientIdRange], ingredientIds: List[Long]): Int = {

    ingredientIds
      .count(new IngredientFreshnessPredicate(freshRanges))
  }

  def countTotalFreshIngredients(ranges: List[IngredientIdRange]): Long = {
    val sorted = ranges.sortBy(_.firstId)

    val merged = sorted.foldLeft(List.empty[IngredientIdRange]) {
      case (Nil, r) => r :: Nil
      case (acc @ last :: rest, r) =>
        if (r.firstId <= last.lastId + 1)
          IngredientIdRange(last.firstId, math.max(last.lastId, r.lastId)) :: rest
        else r :: acc
    }

    merged
      .map(r => r.lastId - r.firstId + 1)
      .sum
  }
}
