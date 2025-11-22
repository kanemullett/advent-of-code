package challenges.aoc2024.day2.service

import challenges.aoc2024.day2.function.ReactorSafetyPredicate
import challenges.aoc2024.day2.model.ReactorReport

class ReactorReportService {

  def calculateTotalSafeReports(reactorReports: List[ReactorReport], isProblemDampenerActive: Boolean): Int = {

    reactorReports.count(new ReactorSafetyPredicate(isProblemDampenerActive))
  }
}
