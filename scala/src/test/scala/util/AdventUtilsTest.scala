package util

import org.scalatest.funsuite.AnyFunSuite

class AdventUtilsTest extends AnyFunSuite {

  test("should parse lines of a text file") {
    // When
    val lines: List[String] = AdventUtils.parseInput(2024, 1)

    // Then
    assert(lines.nonEmpty)
  }
}
