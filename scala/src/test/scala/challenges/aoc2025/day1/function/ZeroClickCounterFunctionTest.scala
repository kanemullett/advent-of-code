package challenges.aoc2025.day1.function

import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor4
import org.scalatest.prop.Tables.Table

class ZeroClickCounterFunctionTest extends AnyFunSuite {

  val cases: TableFor4[Int, String, Int, Int] = Table(
    ("before", "rotation", "after", "zeroClicks"),
    (50, "L68", 82, 1),
    (82, "L30", 52, 0),
    (52, "R48", 0, 1),
    (0, "L5", 95, 0),
    (95, "R60", 55, 1),
    (55, "L55", 0, 1),
    (0, "L1", 99, 0),
    (99, "L99", 0, 1),
    (0, "R14", 14, 0),
    (14, "L82", 32, 1),
    (50, "R1000", 50, 10)
  )
  test("should count number of times dial clicks to zero"):
    forAll(cases) { (before: Int, rotation: String, after: Int, zeroClicks: Int) =>
      // Given
      val dialRotation: DialRotation = DialRotation.of(rotation)
      val function: ZeroClickCounterFunction = new ZeroClickCounterFunction()

      // When
      val clicks: Int = function.apply(before, dialRotation, after)

      // Then
      assert(clicks == zeroClicks)
    }
}
