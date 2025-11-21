package challenges.aoc2024.day1.model

import org.scalatest.funsuite.AnyFunSuite

class ListLinePairTest extends AnyFunSuite {

  test("should build ListLinePair object from left and right values") {
    // When
    val listLinePair: ListLinePair = ListLinePair.of(23, 47)

    // Then
    assert(listLinePair.isInstanceOf[ListLinePair])
    assert(23 == listLinePair.leftValue)
    assert(47 == listLinePair.rightValue)
  }
}
