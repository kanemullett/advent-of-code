package challenges.aoc2025.day3.service

import challenges.aoc2025.day3.model.BatteryBank
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class BatteryServiceTest extends AnyFunSuite with BeforeAndAfter {

  var batteryService: BatteryService = _

  before {
    batteryService = BatteryService()
  }

  test("should calculate total joltage for 2 batteries") {
    // Given
    val banks: List[BatteryBank] = List(
      BatteryBank.of("987654321111111"),
      BatteryBank.of("811111111111119"),
      BatteryBank.of("234234234234278"),
      BatteryBank.of("818181911112111")
    )

    // When
    val total: Long = batteryService.calculateTotalJoltage(banks, 2)

    // Then
    assert(total == 357L)
  }

  test("should calculate total joltage for 12") {
    // Given
    val banks: List[BatteryBank] = List(
      BatteryBank.of("987654321111111"),
      BatteryBank.of("811111111111119"),
      BatteryBank.of("234234234234278"),
      BatteryBank.of("818181911112111")
    )

    // When
    val total: Long = batteryService.calculateTotalJoltage(banks, 12)

    // Then
    assert(total == 3121910778619L)
  }
}
