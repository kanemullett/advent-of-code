package challenges.aoc2024.day3.model

import challenges.aoc2024.day3.util.DayThreeConstants

import scala.util.matching.Regex

case class ComputerMemorySection(instructions: List[MultiplicationInstruction])

object ComputerMemorySection {

  def of(rawMemory: String): ComputerMemorySection = {

    val regex: Regex = DayThreeConstants.multiplicationInstructionRegex

    ComputerMemorySection(
      regex.findAllMatchIn(rawMemory)
        .map(m => MultiplicationInstruction.of(m.group(0)))
        .toList
    )
  }
}
