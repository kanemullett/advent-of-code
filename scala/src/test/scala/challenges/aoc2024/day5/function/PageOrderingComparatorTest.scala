package challenges.aoc2024.day5.function

import challenges.aoc2024.day5.model.PageOrderingRule
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class PageOrderingComparatorTest extends AnyFunSuite {

  val cases: TableFor2[String, String] = Table(
    ("unordered", "ordered"),
    ("75,97,47,61,53", "97,75,47,61,53"),
    ("61,13,29", "61,29,13"),
    ("97,13,75,29,47", "97,75,47,29,13")
  )
  test("should reorder numbers according to rules"):
    forAll(cases) { (unordered: String, ordered: String) =>
      // Given
      val pageOrderingRules: List[PageOrderingRule] = List(
        PageOrderingRule.of("47|53"),
        PageOrderingRule.of("97|13"),
        PageOrderingRule.of("97|61"),
        PageOrderingRule.of("97|47"),
        PageOrderingRule.of("75|29"),
        PageOrderingRule.of("61|13"),
        PageOrderingRule.of("75|53"),
        PageOrderingRule.of("29|13"),
        PageOrderingRule.of("97|29"),
        PageOrderingRule.of("53|29"),
        PageOrderingRule.of("61|53"),
        PageOrderingRule.of("97|53"),
        PageOrderingRule.of("61|29"),
        PageOrderingRule.of("47|13"),
        PageOrderingRule.of("75|47"),
        PageOrderingRule.of("97|75"),
        PageOrderingRule.of("47|61"),
        PageOrderingRule.of("75|61"),
        PageOrderingRule.of("47|29"),
        PageOrderingRule.of("75|13"),
        PageOrderingRule.of("53|13")
      )

      val comparator: PageOrderingComparator = PageOrderingComparator(pageOrderingRules)

      // When
      val sorted: List[Int] = asIntegerList(unordered)
        .sorted(comparator)

      // Then
      assert(asIntegerList(ordered) == sorted)
    }

  private def asIntegerList(input: String): List[Int] = {

    input.split(",")
      .map(_.toInt)
      .toList
  }
}
