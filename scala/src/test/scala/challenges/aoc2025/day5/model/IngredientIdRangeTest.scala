package challenges.aoc2025.day5.model

import org.scalatest.funsuite.AnyFunSuite

class IngredientIdRangeTest extends AnyFunSuite {

  test("should build IngredientIdRange object from string") {
    // When
    val ingredientIdRange: IngredientIdRange = IngredientIdRange.of("3-5")

    // Then
    assert(ingredientIdRange.isInstanceOf[IngredientIdRange])
    assert(ingredientIdRange.firstId == 3L)
    assert(ingredientIdRange.lastId == 5L)

    val values: List[Long] = ingredientIdRange.values
    assert(3L == values.head)
    assert(4L == values(1))
    assert(5L == values(2))
  }
}
