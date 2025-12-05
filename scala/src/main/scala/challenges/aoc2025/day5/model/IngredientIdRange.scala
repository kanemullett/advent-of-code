package challenges.aoc2025.day5.model

case class IngredientIdRange(firstId: Long, lastId: Long)

object IngredientIdRange {

  def of(rangeString: String): IngredientIdRange = {
    val split: Array[String] = rangeString.split("-")

    IngredientIdRange(split.head.toLong, split(1).toLong)
  }
}
