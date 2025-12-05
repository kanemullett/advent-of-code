package challenges.aoc2025.day4.model

import org.scalatest.funsuite.AnyFunSuite

class WarehouseTest extends AnyFunSuite {

  test("should build Warehouse object") {
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

    // When
    val warehouse: Warehouse = Warehouse.of(rowStrings)

    // Then
    assert(warehouse.isInstanceOf[Warehouse])

    val spaces: List[WarehouseSpace] = warehouse.spaces
    assert(spaces.count(_.isInstanceOf[PaperRoll]) == 71)
    assert(spaces.count(_.isInstanceOf[EmptySpace]) == 29)
  }
}
