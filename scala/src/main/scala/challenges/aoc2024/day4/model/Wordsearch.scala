package challenges.aoc2024.day4.model

import model.CoordinatePair

case class Wordsearch(letters: List[WordsearchLetter])

object Wordsearch {

  def of(wordsearchRows: List[String]): Wordsearch = {

    Wordsearch(
      wordsearchRows.flatMap(row => (0 until row.length)
        .map(i => WordsearchLetter(row(i).toString, CoordinatePair(i, wordsearchRows.indexOf(row))))
        .toList)
    )
  }
}
