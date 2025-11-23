package challenges.aoc2024.day4.service

import challenges.aoc2024.day4.model.Wordsearch
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class WordsearchServiceTest extends AnyFunSuite with BeforeAndAfter {

  var wordsearchService: WordsearchService = _

  before {
    wordsearchService = WordsearchService()
  }

  test("should count instances of xmas") {
    // Given
    val wordsearchRows: List[String] = List(
      "MMMSXXMASM",
      "MSAMXMSMSA",
      "AMXSXMAAMM",
      "MSAMASMSMX",
      "XMASAMXAMM",
      "XXAMMXXAMA",
      "SMSMSASXSS",
      "SAXAMASAAA",
      "MAMMMXMMMM",
      "MXMXAXMASX"
    )

    val wordsearch: Wordsearch = Wordsearch.of(wordsearchRows)

    // When
    val xmasCount: Int = wordsearchService.countInstancesOfXmas(wordsearch)

    // Then
    assert(18 == xmasCount)
  }

  test("should count instances of masx") {
    // Given
    val wordsearchRows: List[String] = List(
      "MMMSXXMASM",
      "MSAMXMSMSA",
      "AMXSXMAAMM",
      "MSAMASMSMX",
      "XMASAMXAMM",
      "XXAMMXXAMA",
      "SMSMSASXSS",
      "SAXAMASAAA",
      "MAMMMXMMMM",
      "MXMXAXMASX"
    )

    val wordsearch: Wordsearch = Wordsearch.of(wordsearchRows)

    // When
    val masxCount: Int = wordsearchService.countInstancesOfMasX(wordsearch)

    // Then
    assert(9 == masxCount)
  }
}
