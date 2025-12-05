package challenges.aoc2025.day4.function

import challenges.aoc2025.day4.model.{EmptySpace, PaperRoll, WarehouseSpace}
import model.CoordinatePair
import org.scalatest.funsuite.AnyFunSuite

class PaperRollAccessibilityPredicateTest extends AnyFunSuite {

  test("should determine roll of paper is accessible") {
    // Given
    val adjacent: List[WarehouseSpace] = List(
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0)
    )

    val predicate: PaperRollAccessibilityPredicate = new PaperRollAccessibilityPredicate()

    // When
    val isAccessible: Boolean = predicate.apply(adjacent)

    // Then
    assert(isAccessible)
  }

  test("should determine roll of paper is not accessible") {
    // Given
    val adjacent: List[WarehouseSpace] = List(
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      PaperRoll(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0),
      EmptySpace(CoordinatePair(0, 0), 0, 0)
    )

    val predicate: PaperRollAccessibilityPredicate = new PaperRollAccessibilityPredicate()

    // When
    val isAccessible: Boolean = predicate.apply(adjacent)

    // Then
    assert(!isAccessible)
  }
}
