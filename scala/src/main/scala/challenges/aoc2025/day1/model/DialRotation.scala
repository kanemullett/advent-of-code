package challenges.aoc2025.day1.model

import challenges.aoc2025.day1.model.`type`.RotationDirection

case class DialRotation(direction: RotationDirection, distance: Int)

object DialRotation {

  def of(rotationString: String): DialRotation = {

    val direction: RotationDirection = RotationDirection.of(rotationString(0).toString)
    val distance: Int = rotationString.substring(1).toInt
    
    DialRotation(direction, distance)
  }
}
