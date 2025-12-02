package challenges.aoc2025.day2.service

import challenges.aoc2025.day2.model.IdRange
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class IdValidationServiceTest extends AnyFunSuite with BeforeAndAfter {

  var validationService: IdValidationService = _

  before {
    validationService = IdValidationService()
  }

  test("should calculate total of invalid ids containing exactly two repeats") {
    // Given
    val ranges: List[IdRange] = List(
      IdRange(11L, 22L),
      IdRange(99L, 115L),
      IdRange(998L, 1012L),
      IdRange(1188511880L, 1188511890L),
      IdRange(222220L, 222224L),
      IdRange(1698522L, 1698528L),
      IdRange(446443L, 446449L),
      IdRange(38593856L, 38593862L),
      IdRange(565653L, 565659L),
      IdRange(824824821L, 824824827L),
      IdRange(2121212118L, 2121212124L)
    )

    // When
    val total: Long = validationService.calculateInvalidIdTotal(ranges, true)

    // Then
    assert(total == 1227775554L)
  }

  test("should calculate total of invalid ids containing at least two repeats") {
    // Given
    val ranges: List[IdRange] = List(
      IdRange(11L, 22L),
      IdRange(99L, 115L),
      IdRange(998L, 1012L),
      IdRange(1188511880L, 1188511890L),
      IdRange(222220L, 222224L),
      IdRange(1698522L, 1698528L),
      IdRange(446443L, 446449L),
      IdRange(38593856L, 38593862L),
      IdRange(565653L, 565659L),
      IdRange(824824821L, 824824827L),
      IdRange(2121212118L, 2121212124L)
    )

    // When
    val total: Long = validationService.calculateInvalidIdTotal(ranges, false)

    // Then
    assert(total == 4174379265L)
  }
}
