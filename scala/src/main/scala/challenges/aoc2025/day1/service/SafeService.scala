package challenges.aoc2025.day1.service

import challenges.aoc2025.day1.function.{DialRotationFunction, ZeroClickCounterFunction}
import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection

class SafeService {

  def decipherPassword(rotations: List[DialRotation], passwordMethod: Boolean): Int = {

    val positions: List[Int] = rotations.scanLeft(50)(new DialRotationFunction())

      if passwordMethod then
        positions
          .sliding(2)
          .zip(rotations)
          .map {
            case (Seq(previous, next), rotation) => (previous, rotation, next)
            case (List(_, _, _, _*), DialRotation(_, _)) => (0, DialRotation(RotationDirection.Right, 0), 0)
            case (List(_), DialRotation(_, _)) => (0, DialRotation(RotationDirection.Right, 0), 0)
            case (Nil, DialRotation(_, _)) => (0, DialRotation(RotationDirection.Right, 0), 0)
          }
          .map(new ZeroClickCounterFunction().tupled)
          .sum

      else
        positions.count(_ == 0)
  }
}
