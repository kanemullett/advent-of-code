package challenges.aoc2025.day1.function

import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection

class ZeroClickCounterFunction extends ((Int, DialRotation, Int) => Int) {

  override def apply(before: Int, rotation: DialRotation, after: Int): Int = {

    val base =
      rotation.direction match
        case RotationDirection.Right =>
          (100 - (before % 100)) % 100

        case RotationDirection.Left =>
          before % 100

    val firstK =
      if base == 0 then
        100

      else
        base

    if rotation.distance < firstK then
      0
    else
      1 + (rotation.distance - firstK) / 100
  }
}
