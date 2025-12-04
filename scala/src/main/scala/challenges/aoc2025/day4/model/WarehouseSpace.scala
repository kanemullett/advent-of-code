package challenges.aoc2025.day4.model

import model.CoordinatePair

trait WarehouseSpace {

  def location: CoordinatePair
  
  def warehouseWidth: Int
  
  def warehouseHeight: Int

  def adjacentLocations: List[CoordinatePair] = WarehouseSpace.getAdjacentLocations(location, warehouseWidth, warehouseHeight)
}

object WarehouseSpace {

  def of(spaceString: String, location: CoordinatePair, warehouseWidth: Int, warehouseHeight: Int): WarehouseSpace = {

    if spaceString.equals("@") then
      PaperRoll(location, warehouseWidth, warehouseHeight)

    else
      EmptySpace(location, warehouseWidth, warehouseHeight)
  }
  
  private def getAdjacentLocations(location: CoordinatePair, warehouseWidth: Int, warehouseHeight: Int): List[CoordinatePair] = {
    
    val leftColumn: Int = location.xCoordinate - 1
    val rightColumn: Int = location.xCoordinate + 1
    val aboveRow: Int = location.yCoordinate - 1
    val belowRow: Int = location.yCoordinate + 1
    
    val allDirections: List[CoordinatePair] = List(
      CoordinatePair(leftColumn, aboveRow),
      CoordinatePair(location.xCoordinate, aboveRow),
      CoordinatePair(rightColumn, aboveRow),
      CoordinatePair(leftColumn, location.yCoordinate),
      CoordinatePair(rightColumn, location.yCoordinate),
      CoordinatePair(leftColumn, belowRow),
      CoordinatePair(location.xCoordinate, belowRow),
      CoordinatePair(rightColumn, belowRow)
    )
    
    allDirections
      .filter(adjacent => adjacent.xCoordinate < warehouseWidth 
        && adjacent.xCoordinate >= 0 
        && adjacent.yCoordinate < warehouseHeight 
        && adjacent.yCoordinate >= 0)
  }
}
