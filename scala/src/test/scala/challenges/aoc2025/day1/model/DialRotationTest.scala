package challenges.aoc2025.day1.model

import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection
import org.scalatest.funsuite.AnyFunSuite

class DialRotationTest extends AnyFunSuite {

  test("should build SafeRotation object from string") {
    // When
    val dialRotation: DialRotation = DialRotation.of("R47")

    // Then
    assert(dialRotation.direction == RotationDirection.Right)
    assert(dialRotation.distance == 47)
  }
}
