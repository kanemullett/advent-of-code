package challenges.aoc2025.day2.function

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class IdValidationPredicateTest extends AnyFunSuite {

  val exactlyTwoCases: TableFor2[Long, Boolean] = Table(
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
  test("should determine validity of id, looking for exactly two repeats"):
    forAll(exactlyTwoCases) { (testId: Long, isValid: Boolean) =>
      // Given
      val predicate: IdValidationPredicate = new IdValidationPredicate(true)

      // When
      val checked: Boolean = predicate.apply(testId)

      // Then
      assert(checked == isValid)
    }

  val atLeastTwoCases: TableFor2[Long, Boolean] = Table(
    ("testId", "isValid"),
    (95L, true),
    (96L, true),
    (97L, true),
    (98L, true),
    (99L, false),
    (100L, true),
    (101L, true),
    (102L, true),
    (103L, true),
    (104L, true),
    (105L, true),
    (106L, true),
    (107L, true),
    (108L, true),
    (109L, true),
    (110L, true),
    (111L, false),
    (112L, true),
    (113L, true),
    (114L, true),
    (115L, true)
  )
  test("should determine validity of id, looking for at least two repeats"):
    forAll(atLeastTwoCases) { (testId: Long, isValid: Boolean) =>
      // Given
      val predicate: IdValidationPredicate = new IdValidationPredicate(false)

      // When
      val checked: Boolean = predicate.apply(testId)

      // Then
      assert(checked == isValid)
    }
}
