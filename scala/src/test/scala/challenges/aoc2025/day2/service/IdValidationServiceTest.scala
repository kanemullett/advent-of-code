package challenges.aoc2025.day2.service

import challenges.aoc2025.day2.model.IdRange
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class IdValidationServiceTest extends AnyFunSuite with BeforeAndAfter {

  var validationService: IdValidationService = _

  before {
    validationService = IdValidationService()
  }

  test("should calculate total of invalid ids") {
    // Given
    val ranges: List[IdRange] = List(
      IdRange(11L, 22L),
      IdRange(99L, 115L),
      IdRange(998L, 1012L),
      IdRange(1188511880L, 1188511890L),
      IdRange(222220L, 222224L),
      IdRange(1698522L, 1698528L),
      IdRange(446443L, 446449L),
      IdRange(38593856L, 38593862L)
    )

    // When
    val total: Long = validationService.calculateInvalidIdTotal(ranges)

    // Then
    assert(total == 1227775554L)
  }
}
