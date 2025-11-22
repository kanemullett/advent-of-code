package challenges.aoc2024.day2.function

import challenges.aoc2024.day2.model.ReactorReport
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class ReactorSafetyPredicateTest extends AnyFunSuite {

  val noDampenerCases: TableFor2[String, Boolean] = Table(
    ("inputReport", "expectedSafetyOutcome"),
    ("7 6 4 2 1", true),
    ("1 2 7 8 9", false),
    ("9 7 6 2 1", false),
    ("1 3 2 4 5", false),
    ("8 6 4 4 1", false),
    ("1 3 6 7 9", true)
  )
  test("should determine if reactor is safe with no dampener active"):
    forAll(noDampenerCases) { (inputReport: String, expectedSafetyOutcome: Boolean) =>
      // Given
      val reactorReport: ReactorReport = ReactorReport.of(inputReport)
      val predicate: ReactorSafetyPredicate = new ReactorSafetyPredicate(false)

      // When
      val isSafe: Boolean = predicate.apply(reactorReport)

      // Then
      assert(expectedSafetyOutcome == isSafe)
    }

  val dampenerCases: TableFor2[String, Boolean] = Table(
    ("inputReport", "expectedSafetyOutcome"),
    ("7 6 4 2 1", true),
    ("1 2 7 8 9", false),
    ("9 7 6 2 1", false),
    ("1 3 2 4 5", true),
    ("8 6 4 4 1", true),
    ("1 3 6 7 9", true)
  )
  test("should determine if reactor is safe with dampener active"):
    forAll(dampenerCases) { (inputReport: String, expectedSafetyOutcome: Boolean) =>
      // Given
      val reactorReport: ReactorReport = ReactorReport.of(inputReport)
      val predicate: ReactorSafetyPredicate = new ReactorSafetyPredicate(true)

      // When
      val isSafe: Boolean = predicate.apply(reactorReport)

      // Then
      assert(expectedSafetyOutcome == isSafe)
    }
}
