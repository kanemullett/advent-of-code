package challenges.aoc2025.day2.model

import org.scalatest.funsuite.AnyFunSuite

class IdRangeTest extends AnyFunSuite {

  test("should build IdRange object from string") {
    // When
    val idRange: IdRange = IdRange.of("11-22")

    // Then
    assert(idRange.firstId == 11L)
    assert(idRange.lastId == 22L)
  }
}
