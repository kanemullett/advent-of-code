package challenges.aoc2024.day3.model

import org.scalatest.funsuite.AnyFunSuite

class ComputerMemoryTest extends AnyFunSuite {

  test("should build ComputerMemorySection object from string") {
    // When
    val memory: ComputerMemorySection = ComputerMemorySection.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")

    // Then
    assert(memory.isInstanceOf[ComputerMemorySection])
    assert(4 == memory.instructions.size)
    assert(MultiplicationInstruction(2, 4) == memory.instructions.head)
    assert(MultiplicationInstruction(5, 5) == memory.instructions(1))
    assert(MultiplicationInstruction(11, 8) == memory.instructions(2))
    assert(MultiplicationInstruction(8, 5) == memory.instructions(3))
  }
}
