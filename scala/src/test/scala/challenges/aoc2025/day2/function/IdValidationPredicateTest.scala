package challenges.aoc2025.day2.function

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class IdValidationPredicateTest extends AnyFunSuite {

  val cases: TableFor2[Long, Boolean] = Table(
    ("testId", "isValid"),
    (11L, false),
    (12L, true),
    (13L, true),
    (14L, true),
    (15L, true),
    (16L, true),
    (17L, true),
    (18L, true),
    (19L, true),
    (20L, true),
    (21L, true),
    (22L, false),
    (446446L, false)
  )
  test("should determine validity of id"):
    forAll(cases) { (testId: Long, isValid: Boolean) =>
      // Given
      val predicate: IdValidationPredicate = new IdValidationPredicate()

      // When
      val checked: Boolean = predicate.apply(testId)

      // Then
      assert(checked == isValid)
    }
}
