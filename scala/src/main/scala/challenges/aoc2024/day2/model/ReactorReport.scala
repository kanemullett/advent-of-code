package challenges.aoc2024.day2.model

case class ReactorReport(levels: List[Int])

object ReactorReport {
  def of(reportLine: String): ReactorReport = {
    ReactorReport(reportLine.split(" ").toList.map(_.toInt))
  }
}
