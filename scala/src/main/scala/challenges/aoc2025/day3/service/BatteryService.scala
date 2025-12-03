package challenges.aoc2025.day3.service

import challenges.aoc2025.day3.model.BatteryBank

import scala.annotation.tailrec

class BatteryService {

  def calculateTotalJoltage(banks: List[BatteryBank], batteryCount: Long): Long = {

   banks
     .map(bank => buildCombination(bank.batteries, batteryCount))
     .sum
  }

  private def buildCombination(batteries: List[Long], batteryCount: Long): Long = {
    
    if batteryCount <= 0 then
      0L
      
    else if batteryCount >= batteries.length then
      batteries.foldLeft(0L)((acc, d) => acc * 10 + d)
      
    else
      buildMaxSubsequence(batteries, batteryCount.toInt)
  }

  private def buildMaxSubsequence(batteries: List[Long], batteryCount: Int): Long = {
    val toDrop = batteries.length - batteryCount

    val best = selectBestDigits(batteries, Nil, toDrop)
    val chosen = best.reverse.take(batteryCount)

    chosen.foldLeft(0L)((acc, d) => acc * 10 + d)
  }

  @tailrec
  private def selectBestDigits(remainingDigits: List[Long], chosen: List[Long], dropBudget: Int): List[Long] = {

    remainingDigits match
      case Nil => chosen
      case currentDigit :: restOfDigits =>

        val (stackAfterPop, remainingDrop) = removeSmallerPrefix(chosen, dropBudget, currentDigit)
        selectBestDigits(restOfDigits, currentDigit :: stackAfterPop, remainingDrop)
  }

  @tailrec
  private def removeSmallerPrefix(currentChosen: List[Long], remainingDrop: Int, currentDigit: Long): (List[Long], Int) = {

    currentChosen match
      case last :: tail if remainingDrop > 0 && last < currentDigit => removeSmallerPrefix(tail, remainingDrop - 1, currentDigit)
      case _ => (currentChosen, remainingDrop)
  }
}
