package challenges.aoc2024.day1.model

case class LocationLists(linePairs: List[ListLinePair])

object LocationLists {
  def of(unorderedListPairStrings: List[String]): LocationLists = {
    val leftList: List[Int] = unorderedListPairStrings
      .map(_.split(" {3}")(0))
      .map(_.toInt)
      .sorted

    val rightList: List[Int] = unorderedListPairStrings
      .map(_.split(" {3}")(1))
      .map(_.toInt)
      .sorted

    LocationLists(
      leftList.indices
        .map(i => ListLinePair(leftList(i), rightList(i)))
        .toList
    )
  }
}
