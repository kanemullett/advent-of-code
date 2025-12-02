package challenges.aoc2025.day2.model

case class IdRange(firstId: Long, lastId: Long)

object IdRange {

  def of(rangeString: String): IdRange = {
    val split: Array[String] = rangeString.split("-")
    
    IdRange(split(0).toLong, split(1).toLong)
  }
}
