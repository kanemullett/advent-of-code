package challenges.aoc2025.day2.function

class IdValidationPredicate extends (Long => Boolean) {

  override def apply(id: Long): Boolean = {
    val stringId: String = id.toString

    if stringId.length % 2 == 1 then
      true

    else
      val (first: String, second: String) = stringId.splitAt(stringId.length / 2)
      !first.equals(second)
  }
}
