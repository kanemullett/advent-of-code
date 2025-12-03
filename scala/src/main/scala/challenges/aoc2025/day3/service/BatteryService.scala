package challenges.aoc2025.day3.service

import challenges.aoc2025.day3.model.BatteryBank

class BatteryService {

  def calculateTotalJoltage(banks: List[BatteryBank]): Int = {

   banks
     .map(calculateJoltage)
     .sum
  }

  private def calculateJoltage(bank: BatteryBank): Int = {

    (1 to 9)
      .map(first => findLargestJoltage(bank.batteries, first))
      .max
  }

  private def findLargestJoltage(batteries: List[Int], potentialFirstBattery: Int): Int = {
    
    if !batteries.contains(potentialFirstBattery) then
      0
    
    else 
      val firstIndex: Int = batteries.indexOf(potentialFirstBattery)
      val potentialSeconds: List[Int] = batteries.drop(firstIndex + 1)
      
      if potentialSeconds.isEmpty then
        potentialFirstBattery

      else
        s"$potentialFirstBattery${potentialSeconds.max}".toInt
  }
}
