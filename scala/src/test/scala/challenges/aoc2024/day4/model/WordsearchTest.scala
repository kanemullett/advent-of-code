package challenges.aoc2024.day4.model

import model.CoordinatePair
import org.scalatest.funsuite.AnyFunSuite

class WordsearchTest extends AnyFunSuite {

  test("should build Wordsearch object from rows") {
    // Given
    val rows: List[String] = List("HELLO", "THERE")

    // When
    val wordsearch: Wordsearch = Wordsearch.of(rows)

    // Then
    assert(wordsearch.isInstanceOf[Wordsearch])
    assert(10 == wordsearch.letters.size)

    val letterH: WordsearchLetter = wordsearch.letters.head
    assert("H" == letterH.letter)
    assert(CoordinatePair(0, 0) == letterH.position)

    val letterE: WordsearchLetter = wordsearch.letters(9)
    assert("E" == letterE.letter)
    assert(CoordinatePair(4, 1) == letterE.position)
  }
}
