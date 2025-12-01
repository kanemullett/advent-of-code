package challenges.aoc2024.day5.function

import challenges.aoc2024.day5.model.{PageOrderingRule, ProductionUpdate}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class CorrectlyOrderedPagesPredicateTest extends AnyFunSuite {

  val cases: TableFor2[String, Boolean] = Table(
    ("updateString", "isCorrectlyOrdered"),
    ("75,47,61,53,29", true),
    ("97,61,53,29,13", true),
    ("75,29,13", true),
    ("75,97,47,61,53", false),
    ("61,13,29", false),
    ("97,13,75,29,47", false)
  )
  test("should determine whether update is correctly ordered"):
    forAll(cases) { (updateString: String, isCorrectlyOrdered: Boolean) =>
      // Given
      val productionUpdate: ProductionUpdate = ProductionUpdate.of(updateString)

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

      val predicate: CorrectlyOrderedPagesPredicate = CorrectlyOrderedPagesPredicate(pageOrderingRules)

      // When
      val ordered: Boolean = predicate.apply(productionUpdate)

      // Then
      assert(isCorrectlyOrdered == ordered)
    }
}
