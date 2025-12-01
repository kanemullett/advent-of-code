package challenges.aoc2025.day1.service

import challenges.aoc2025.day1.function.DialRotationFunction
import challenges.aoc2025.day1.model.DialRotation

class SafeService {

  def decipherPassword(rotations: List[DialRotation]): Int = {

    rotations.scanLeft(50)(new DialRotationFunction())
      .count(_ == 0)
  }
}
