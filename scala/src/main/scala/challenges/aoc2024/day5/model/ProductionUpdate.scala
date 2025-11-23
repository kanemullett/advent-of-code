package challenges.aoc2024.day5.model

case class ProductionUpdate(pages: List[Int])

object ProductionUpdate {

  def of(updateString: String): ProductionUpdate = {
    val pages: List[Int] = updateString.split(",")
      .map(_.toInt)
      .toList
    
    ProductionUpdate(pages)
  }
}
