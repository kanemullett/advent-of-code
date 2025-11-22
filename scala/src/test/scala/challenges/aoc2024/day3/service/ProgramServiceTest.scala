package challenges.aoc2024.day3.service

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class ProgramServiceTest extends AnyFunSuite with BeforeAndAfter {

  private var programService: ProgramService = _

  before {
    programService = ProgramService()
  }

  val cases: TableFor2[Boolean, Int] = Table(
    ("conditionalsIntact", "expectedTotal"),
    (false, 161),
    (true, 48)
  )
  test("should calculate total of multiplication instructions"):
    forAll(cases) { (conditionalsIntact: Boolean, expectedTotal: Int) =>
      // When
      val total: Int = programService.calculateTotalOfMultiplicationInstructions("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))", conditionalsIntact)

      // Then
      assert(expectedTotal == total)
    }
}
