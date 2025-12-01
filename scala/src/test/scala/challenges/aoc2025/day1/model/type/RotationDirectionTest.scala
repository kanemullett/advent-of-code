package challenges.aoc2025.day1.model.`type`

import challenges.aoc2025.day1.model.`type`.RotationDirection
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class RotationDirectionTest extends AnyFunSuite {

  val cases: TableFor2[String, RotationDirection] = Table(
    ("directionString", "expectedDirection"),
    ("L", RotationDirection.Left),
    ("R", RotationDirection.Right)
  )
  test("should build RotationDirection from string"):
    forAll(cases) { (directionString: String, expectedDirection: RotationDirection) =>
      // When
      val rotationDirection = RotationDirection.of(directionString)

      // Then
      assert(rotationDirection == expectedDirection)
    }
}
