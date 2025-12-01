package challenges.aoc2024.day3.model

import org.scalatest.funsuite.AnyFunSuite

class MultiplicationInstructionTest extends AnyFunSuite {

  test("should build MultiplicationInstruction from string") {
    // When
    val instruction: MultiplicationInstruction = MultiplicationInstruction.of("mul(123,99)")

    // Then
    assert(instruction.isInstanceOf[MultiplicationInstruction])
    assert(123 == instruction.firstValue)
    assert(99 == instruction.secondValue)
  }

  test("should build MultiplicationInstruction from values") {
    // When
    val instruction: MultiplicationInstruction = MultiplicationInstruction(123, 99)

    // Then
    assert(instruction.isInstanceOf[MultiplicationInstruction])
    assert(123 == instruction.firstValue)
    assert(99 == instruction.secondValue)
  }
}
