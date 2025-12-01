package challenges.aoc2024.day4.model

import model.CoordinatePair
import org.scalatest.funsuite.AnyFunSuite

class WordsearchLetterTest extends AnyFunSuite {

  test("should build WordsearchLetter object from letter and position") {
    // When
    val letter: WordsearchLetter = WordsearchLetter("k", CoordinatePair(2, 3))

    // Then
    assert(letter.isInstanceOf[WordsearchLetter])
    assert("k" == letter.letter)
    assert(CoordinatePair(2, 3) == letter.position)
  }
}
