package challenges.aoc2024.day3.util

import scala.util.matching.Regex

object DayThreeConstants {
  val multiplicationInstructionRegex: Regex = raw"mul\((-?\d+),(-?\d+)\)".r
  val doDontSectionRegex: Regex = raw"(?<=do\(\))(.*?)(?=don't\(\))".r
}
