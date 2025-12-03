package challenges.aoc2025.day3.model

case class BatteryBank(batteries: List[Long])

object BatteryBank {
  
  def of(bankString: String): BatteryBank = {
    
    val batteries: List[Long] = bankString.split("")
      .map(_.toLong)
      .toList
    
    BatteryBank(batteries)
  }
}
