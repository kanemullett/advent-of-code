package util

import scala.io.Source

class AdventUtils {

  def parseInput(year: Int, day: Int): List[String] = {
    val path: String = f"./src/main/resources/aoc$year/day$day.txt"

    try {
      val source = Source.fromFile(path)
      try source.getLines().toList
      finally source.close()
    } catch {
      case _: java.io.FileNotFoundException =>
      println(s"Input file not found: $path")
      List.empty
    }
  }
}
