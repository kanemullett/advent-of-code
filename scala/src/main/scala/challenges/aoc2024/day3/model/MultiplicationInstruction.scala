package challenges.aoc2024.day3.model

import challenges.aoc2024.day3.util.DayThreeConstants

import scala.util.matching.Regex

case class MultiplicationInstruction(firstValue: Int, secondValue: Int)

object MultiplicationInstruction {

  def of(multiplicationInstruction: String): MultiplicationInstruction = {
    val regex: Regex = DayThreeConstants.multiplicationInstructionRegex

    multiplicationInstruction match
      case regex(a, b) =>
        MultiplicationInstruction(a.toInt, b.toInt)

      case _ =>
        throw new IllegalArgumentException("Invalid multiplication instruction.")
  }
}
