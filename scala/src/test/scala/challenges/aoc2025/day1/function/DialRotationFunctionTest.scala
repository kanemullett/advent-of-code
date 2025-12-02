package challenges.aoc2025.day1.function

import challenges.aoc2025.day1.function.DialRotationFunction
import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection
import org.scalatest.funsuite.AnyFunSuite

class DialRotationFunctionTest extends AnyFunSuite {

  test("should rotate dial right past 99") {
    // Given
    val function: DialRotationFunction = new DialRotationFunction()

    val startingPosition: Int = 95
    val dialRotation: DialRotation = DialRotation(RotationDirection.Right, 60)

    // When
    val rotated: Int = function.apply(startingPosition, dialRotation)

    // Then
    assert(rotated == 55)
  }

  test("should rotate dial left past 0") {
    // Given
    val function: DialRotationFunction = new DialRotationFunction()

    val startingPosition: Int = 14
    val dialRotation: DialRotation = DialRotation(RotationDirection.Left, 82)

    // When
    val rotated: Int = function.apply(startingPosition, dialRotation)

    // Then
    assert(rotated == 32)
  }
}
