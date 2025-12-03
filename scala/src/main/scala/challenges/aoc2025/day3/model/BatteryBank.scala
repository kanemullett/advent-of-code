package challenges.aoc2025.day3.model

case class BatteryBank(batteries: List[Int])

object BatteryBank {
  
  def of(bankString: String): BatteryBank = {
    
    val batteries: List[Int] = bankString.split("")
      .map(_.toInt)
      .toList
    
    BatteryBank(batteries)
  }
}
