package challenges.aoc2025.day2.service

import challenges.aoc2025.day2.function.IdValidationPredicate
import challenges.aoc2025.day2.model.IdRange

class IdValidationService {

  def calculateInvalidIdTotal(idRanges: List[IdRange]): Long = {

    idRanges
      .map(range => (range.firstId to range.lastId)
        .filterNot(new IdValidationPredicate())
        .sum)
      .sum
  }
}
