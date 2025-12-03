package challenges.aoc2025.day3.service

import challenges.aoc2025.day3.model.BatteryBank
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class BatteryServiceTest extends AnyFunSuite with BeforeAndAfter {

  var batteryService: BatteryService = _

  before {
    batteryService = BatteryService()
  }

  test("should calculate total joltage") {
    // Given
    val banks: List[BatteryBank] = List(
      BatteryBank.of("987654321111111"),
      BatteryBank.of("811111111111119"),
      BatteryBank.of("234234234234278"),
      BatteryBank.of("818181911112111"),
      BatteryBank.of("987654321111119"),
    )

    // When
    val total: Int = batteryService.calculateTotalJoltage(banks)

    // Then
    assert(total == 456)
  }
}
