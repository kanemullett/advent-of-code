package challenges.aoc2024.day1.model

import org.scalatest.funsuite.AnyFunSuite

class LocationListTest extends AnyFunSuite {

  test("should build LocationList object from input strings") {
    // Given
    val inputStrings: List[String] = List("3   4", "4   3", "2   5", "1   3", "3   9", "3   3")

    // When
    val locationLists: LocationLists = LocationLists.of(inputStrings)

    // Then
    assert(6 == locationLists.linePairs.size)

    assert(ListLinePair(1, 3) == locationLists.linePairs.head)
    assert(ListLinePair(2, 3) == locationLists.linePairs(1))
    assert(ListLinePair(3, 3) == locationLists.linePairs(2))
    assert(ListLinePair(3, 4) == locationLists.linePairs(3))
    assert(ListLinePair(3, 5) == locationLists.linePairs(4))
    assert(ListLinePair(4, 9) == locationLists.linePairs(5))
  }
}
