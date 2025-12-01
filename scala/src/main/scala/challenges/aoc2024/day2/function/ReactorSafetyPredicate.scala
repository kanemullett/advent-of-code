package challenges.aoc2024.day2.function

import challenges.aoc2024.day2.model.ReactorReport
import challenges.aoc2024.day2.model.`type`.GradientDirection

class ReactorSafetyPredicate(isProblemDampenerActive: Boolean) extends (ReactorReport => Boolean) {

  override def apply(reactorReport: ReactorReport): Boolean = {

    val initiallySafe: Boolean = isSafe(reactorReport.levels)

    if !isProblemDampenerActive || initiallySafe then
      initiallySafe
    else
      reactorReport.levels.indices
        .map(indexToIgnore => reactorReport.levels.indices
          .filter(_.!=(indexToIgnore))
          .map(reactorReport.levels)
          .toList)
        .filter(isSafe)
        .toList.nonEmpty
  }

  private def isSafe(levels: List[Int]): Boolean = {

    try
      val direction = determineGradientDirection(levels).get
      levels
        .sliding(2)
        .collect { case Seq(a, b) => (a, b) }
        .forall((a, b) => isSafeIncreaseOrDecrease(direction, a, b))
    catch
      case e: NoSuchElementException => false
  }

  private def determineGradientDirection(levels: List[Int]): Option[GradientDirection] = {

    if levels.distinct.size != levels.size then
      None
    else
      val changes: List[GradientDirection] =
        levels.sliding(2).collect {
          case List(a, b) =>
            if a > b then GradientDirection.Decrease
            else GradientDirection.Increase
        }.toList

      changes.distinct match {
        case dir :: Nil => Some(dir)
        case _ => None
      }
  }

  private def isSafeIncreaseOrDecrease(direction: GradientDirection, startLevel: Int, nextLevel: Int): Boolean = {
    (direction == GradientDirection.Increase && startLevel < nextLevel && startLevel + 3 >= nextLevel)
    || (direction == GradientDirection.Decrease && startLevel > nextLevel && startLevel - 3 <= nextLevel)
  }
}
