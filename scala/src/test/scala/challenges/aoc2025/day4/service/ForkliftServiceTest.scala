package challenges.aoc2025.day4.service

import challenges.aoc2025.day4.model.Warehouse
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class ForkliftServiceTest extends AnyFunSuite with BeforeAndAfter {

  var forkliftService: ForkliftService = _

  before {
    forkliftService = ForkliftService()
  }

  test("should calculate number of accessible rolls of paper") {
    // Given
    val rowStrings: List[String] = List(
      "..@@.@@@@.",
      "@@@.@.@.@@",
      "@@@@@.@.@@",
      "@.@@@@..@.",
      "@@.@@@@.@@",
      ".@@@@@@@.@",
      ".@.@.@.@@@",
      "@.@@@.@@@@",
      ".@@@@@@@@.",
      "@.@.@@@.@."
    )
    val warehouse: Warehouse = Warehouse.of(rowStrings)

    // When
    val accessible: Int = forkliftService.calculateTotalAccessiblePaperRolls(warehouse)

    // Then
    assert(accessible == 13)
  }
}
