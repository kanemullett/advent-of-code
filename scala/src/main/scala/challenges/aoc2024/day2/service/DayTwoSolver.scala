package challenges.aoc2024.day2.service

import challenges.aoc2024.day2.model.ReactorReport
import service.DaySolver
import util.AdventUtils

class DayTwoSolver(reactorReportService: ReactorReportService) extends DaySolver {
  private val inputLines: List[String] = AdventUtils.parseInput(2024, 2)

  override def taskOne(): String = {

    val reactorReports: List[ReactorReport] = inputLines
      .map(ReactorReport.of)

    reactorReportService.calculateTotalSafeReports(reactorReports, false).toString
  }

  override def taskTwo(): String = {

    val reactorReports: List[ReactorReport] = inputLines
      .map(ReactorReport.of)

    reactorReportService.calculateTotalSafeReports(reactorReports, true).toString
  }
}
