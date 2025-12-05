package challenges.aoc2025.day4.service

import challenges.aoc2025.day4.function.PaperRollAccessibilityPredicate
import challenges.aoc2025.day4.model.{EmptySpace, PaperRoll, Warehouse, WarehouseSpace}

import scala.annotation.tailrec

class ForkliftService {

  private val paperRollAccessibilityPredicate: PaperRollAccessibilityPredicate = new PaperRollAccessibilityPredicate()

  def calculateTotalAccessiblePaperRolls(warehouse: Warehouse): Int = {

    findAccessiblePaperRolls(warehouse.spaces).length
  }

  def calculateTotalRemovablePaperRolls(warehouse: Warehouse): Int = {

    val rollsBefore: Int = warehouse.spaces
      .count(_.isInstanceOf[PaperRoll])

    val rollsAfter:Int = removeRolls(warehouse).spaces
      .count(_.isInstanceOf[PaperRoll])

    rollsBefore - rollsAfter
  }

  private def findAccessiblePaperRolls(warehouseSpaces: List[WarehouseSpace]): List[WarehouseSpace] = {

    warehouseSpaces
      .filter(_.isInstanceOf[PaperRoll])
      .map(paperRoll => paperRoll -> paperRoll.adjacentLocations
        .map(adjacent => warehouseSpaces
          .find(_.location == adjacent)
          .get))
      .toMap
      .filter((k, v) => paperRollAccessibilityPredicate.apply(v))
      .map((k, v) => k)
      .toList
  }

  @tailrec
  private def removeRolls(warehouse: Warehouse): Warehouse = {

    val toRemove: List[WarehouseSpace] = findAccessiblePaperRolls(warehouse.spaces)

    if toRemove.isEmpty then
      warehouse

    else
      val newSpaces: List[WarehouseSpace] = warehouse.spaces
        .map(space => if toRemove
          .map(_.location).contains(space.location) then
          EmptySpace(space.location, space.warehouseWidth, space.warehouseHeight) else space)

      val newWarehouse: Warehouse = Warehouse(newSpaces)
      removeRolls(newWarehouse)
  }
}
