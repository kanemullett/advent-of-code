package challenges.aoc2024.day1.service

import challenges.aoc2024.day1.model.LocationLists
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class ListServiceTest extends AnyFunSuite with BeforeAndAfter {

  private var listService: ListService = _

  before {
    listService = ListService()
  }

  test("should calculate total list distance") {
    // Given
    val locationLists: LocationLists = LocationLists.of(List("3   4", "4   3", "2   5", "1   3", "3   9", "3   3"))

    // When
    val totalDistance: Int = listService.calculateTotalListDistance(locationLists)

    // Then
    assert(11 == totalDistance)
  }

  test("should calculate total similarity score") {
    // Given
    val locationLists: LocationLists = LocationLists.of(List("3   4", "4   3", "2   5", "1   3", "3   9", "3   3"))

    // When
    val totalSimilarityScore: Int = listService.calculateTotalSimilarityScore(locationLists)

    // Then
    assert(31 == totalSimilarityScore)
  }
}
