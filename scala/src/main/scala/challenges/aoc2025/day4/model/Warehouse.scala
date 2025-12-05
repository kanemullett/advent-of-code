package challenges.aoc2025.day4.model

import model.CoordinatePair

case class Warehouse(spaces: List[WarehouseSpace])

object Warehouse {

  def of(warehouseRows: List[String]): Warehouse = {
    
    val spaces: List[WarehouseSpace] = warehouseRows.indices
      .flatMap(row => warehouseRows(row).split("").indices
        .map(col => WarehouseSpace.of(
          warehouseRows(row).split("")(col), 
          CoordinatePair(col, row), 
          warehouseRows(row).length, 
          warehouseRows.length)))
      .toList
    
    Warehouse(spaces)
  }
}
