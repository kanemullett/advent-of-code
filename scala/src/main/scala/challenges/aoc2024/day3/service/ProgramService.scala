package challenges.aoc2024.day3.service

import challenges.aoc2024.day3.model.ComputerMemorySection
import challenges.aoc2024.day3.util.DayThreeConstants

import scala.util.matching.Regex

class ProgramService {

  private val doStatement: String = "do()"
  private val dontStatement: String = "don't()"

  def calculateTotalOfMultiplicationInstructions(rawMemory: String, conditionalsIntact: Boolean): Int = {

    val memory: ComputerMemorySection =
      if conditionalsIntact then
        val regex: Regex = DayThreeConstants.doDontSectionRegex
  
        var toCheck: List[String] = List(rawMemory.substring(0, rawMemory.indexOf(dontStatement)))
        val after: String = rawMemory.substring(rawMemory.lastIndexOf(doStatement) + 4)
  
        if !after.contains(dontStatement) then
          toCheck = toCheck :+ after
  
        toCheck = toCheck ++ regex.findAllMatchIn(rawMemory)
          .map(_.group(1))
  
        ComputerMemorySection(
          toCheck
            .map(ComputerMemorySection.of)
            .flatMap(_.instructions)
        )
  
      else
        ComputerMemorySection.of(rawMemory)

    memory.instructions
      .map(instruction => instruction.firstValue * instruction.secondValue)
      .sum
  }
}
