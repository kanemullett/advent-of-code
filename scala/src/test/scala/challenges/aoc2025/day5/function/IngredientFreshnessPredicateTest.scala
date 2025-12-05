package challenges.aoc2025.day5.function

import challenges.aoc2025.day5.model.IngredientIdRange
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class IngredientFreshnessPredicateTest extends AnyFunSuite {

  val cases: TableFor2[Long, Boolean] = Table(
    ("ingredientId", "isFresh"),
    (3L, true),
    (13L, true),
    (15L, false)
  )
  test("should determine whether ingredientId is fresh"):
    forAll(cases) { (ingredientId: Long, isFresh: Boolean) =>
      // Given
      val freshRanges: List[IngredientIdRange] = List(
        IngredientIdRange(3, 5),
        IngredientIdRange(10, 14)
      )
      val predicate: IngredientFreshnessPredicate = IngredientFreshnessPredicate(freshRanges)

      // When
      val tested: Boolean = predicate.apply(ingredientId)

      // Then
      assert(tested == isFresh)
    }
}
