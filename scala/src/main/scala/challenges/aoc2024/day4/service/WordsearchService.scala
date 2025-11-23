package challenges.aoc2024.day4.service

import challenges.aoc2024.day4.model.{Wordsearch, WordsearchLetter}
import model.CoordinatePair

class WordsearchService {

  private val vectors: List[CoordinatePair] = List(
    CoordinatePair(-1, -1),
    CoordinatePair(0, -1),
    CoordinatePair(1, -1),
    CoordinatePair(-1, 0),
    CoordinatePair(1, 0),
    CoordinatePair(-1, 1),
    CoordinatePair(0, 1),
    CoordinatePair(1, 1)
  )

  private val masString: String = "MAS"

  def countInstancesOfXmas(wordsearch: Wordsearch): Int = {

    wordsearch.letters
      .filter(letter => "X".equals(letter.letter))
      .flatMap(xLetter => vectors
        .map(vector => nextThreeLetters(wordsearch.letters, xLetter.position, vector, false)
          .map(_.letter)
          .mkString("")))
      .count(_.equals(masString))
  }

  def countInstancesOfMasX(wordsearch: Wordsearch): Int = {

    wordsearch.letters
      .filter(letter => "M".equals(letter.letter))
      .map(mLetter => vectors
        .filter(vec => vec.xCoordinate != 0 && vec.yCoordinate != 0)
        .map(vector => nextThreeLetters(wordsearch.letters, mLetter.position, vector, true))
        .filter(characterSet => masString.equals(characterSet
          .map(_.letter)
          .mkString(""))))
      .filter(_.nonEmpty)
      .flatMap(_.map(_(1)))
      .map(_.position)
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .toMap
      .count { case (_, value) => value == 2 }
  }

  private def areEqual(firstCoordinate: CoordinatePair, secondCoordinate: CoordinatePair): Boolean = {
    firstCoordinate.xCoordinate == secondCoordinate.xCoordinate
    && firstCoordinate.yCoordinate == secondCoordinate.yCoordinate
  }

  private def nextThreeLetters(letters: List[WordsearchLetter], startPosition: CoordinatePair, movementVector: CoordinatePair, includeStart: Boolean): List[WordsearchLetter] = {
    val intRange: Range = if includeStart then 0 until 3 else 1 until 4

    intRange.flatMap(i => letters
      .filter(letter => areEqual(letter.position, CoordinatePair(startPosition.xCoordinate + (movementVector.xCoordinate * i), startPosition.yCoordinate + (movementVector.yCoordinate * i)))))
      .toList
  }
}
