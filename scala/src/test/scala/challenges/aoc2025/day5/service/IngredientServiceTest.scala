package challenges.aoc2025.day5.service

import challenges.aoc2025.day5.model.IngredientIdRange
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class IngredientServiceTest extends AnyFunSuite with BeforeAndAfter {

  var ingredientService: IngredientService = _

  before {
    ingredientService = IngredientService()
  }

  test("should count number of fresh ingredients") {
    // Given
    val freshRanges: List[IngredientIdRange] = List(
      IngredientIdRange(3, 5),
      IngredientIdRange(10, 14),
      IngredientIdRange(16, 20),
      IngredientIdRange(12, 18)
    )

    val ingredientIds: List[Long] = List(1, 5, 8, 11, 17, 32)

    // When
    val freshIngredientCount: Int = ingredientService.countFreshIngredients(freshRanges, ingredientIds)

    // Then
    assert(freshIngredientCount == 3)
  }

  test("should count total of fresh ingredients") {
    // Given
    val freshRanges: List[IngredientIdRange] = List(
      IngredientIdRange(3, 5),
      IngredientIdRange(10, 14),
      IngredientIdRange(16, 20),
      IngredientIdRange(12, 18)
    )

    val ingredientIds: List[Long] = List(1, 5, 8, 11, 17, 32)

    // When
    val freshIngredientCount: Long = ingredientService.countTotalFreshIngredients(freshRanges)

    // Then
    assert(freshIngredientCount == 14)
  }
}
