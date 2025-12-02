package challenges.aoc2025.day1.function

import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection

class DialRotationFunction extends ((Int, DialRotation) => Int) {

  override def apply(currentPosition: Int, rotationInstruction: DialRotation): Int = {

    val result: Int =
      if rotationInstruction.direction == RotationDirection.Left then
        currentPosition - rotationInstruction.distance

      else
        currentPosition + rotationInstruction.distance

    ((result % 100) + 100) % 100
  }
}
