package challenges.aoc2025.day3.model

import org.scalatest.funsuite.AnyFunSuite

class BatteryBankTest extends AnyFunSuite {

  test("should build BatteryBank object from string") {
    // When
    val batteryBank: BatteryBank = BatteryBank.of("987654321111111")

    // Then
    assert(batteryBank.isInstanceOf[BatteryBank])
    assert(batteryBank.batteries == List(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1))
  }
}
