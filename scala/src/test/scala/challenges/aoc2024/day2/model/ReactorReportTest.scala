package challenges.aoc2024.day2.model

import org.scalatest.funsuite.AnyFunSuite

class ReactorReportTest extends AnyFunSuite {

  test("should build ReactorReport object from string") {
    // Given
    val input: String = "7 6 4 2 1"

    // When
    val reactorReport: ReactorReport = ReactorReport.of(input)

    // Then
    assert(reactorReport.isInstanceOf[ReactorReport])
    assert(5 == reactorReport.levels.size)
    assert(7 == reactorReport.levels.head)
    assert(6 == reactorReport.levels(1))
    assert(4 == reactorReport.levels(2))
    assert(2 == reactorReport.levels(3))
    assert(1 == reactorReport.levels(4))
  }
}
