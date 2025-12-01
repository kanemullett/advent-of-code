package challenges.aoc2024.day1.service

import challenges.aoc2024.day1.model.LocationLists

class ListService {

  def calculateTotalListDistance(locationLists: LocationLists): Int = {

    locationLists.linePairs
      .map(pair => Math.abs(pair.leftValue - pair.rightValue))
      .sum
  }

  def calculateTotalSimilarityScore(locationLists: LocationLists): Int = {

    locationLists.linePairs
      .map(_.leftValue)
      .map(leftValue => leftValue * locationLists.linePairs
        .map(_.rightValue)
        .count(_ == leftValue))
      .sum
  }
}
