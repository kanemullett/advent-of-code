package challenges.aoc2025.day2.function

class IdValidationPredicate(exactlyTwice: Boolean) extends (Long => Boolean) {

  override def apply(id: Long): Boolean = {
    val stringId: String = id.toString

    if exactlyTwice then
      !stringId.matches("""^(.+)\1$""")

    else
      !stringId.matches("""^(.+)\1+$""")
  }
}
