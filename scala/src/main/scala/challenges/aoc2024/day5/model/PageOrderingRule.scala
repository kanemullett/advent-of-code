package challenges.aoc2024.day5.model

case class PageOrderingRule(beforeNumber: Int, afterNumber: Int)

object PageOrderingRule {

  def of(ruleString: String): PageOrderingRule = {
    val ruleParts: Array[String] = ruleString.split("\\|")

    PageOrderingRule(ruleParts(0).toInt, ruleParts(1).toInt)
  }
}
