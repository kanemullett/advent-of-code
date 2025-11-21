package challenges.aoc2024.day1.model

case class ListLinePair(leftValue: Int, rightValue: Int)

object ListLinePair {
  def of(leftValue: Int, rightValue: Int): ListLinePair = {
    ListLinePair(leftValue, rightValue)
  }
}
