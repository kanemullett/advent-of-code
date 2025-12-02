package challenges.aoc2025.day1.service

import challenges.aoc2025.day1.model.DialRotation
import challenges.aoc2025.day1.model.`type`.RotationDirection
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class SafeServiceTest extends AnyFunSuite with BeforeAndAfter {

  private var safeService: SafeService = _

  before {
    safeService = SafeService()
  }

  val cases: TableFor2[Boolean, Int] = Table(
    ("passwordMethod", "expectedPassword"),
    (false, 3),
    (true, 6)
  )
  test("should decipher password"):
    forAll(cases) { (passwordMethod: Boolean, expectedPassword: Int) =>
      // Given
      val rotations: List[DialRotation] = List(
        DialRotation(RotationDirection.Left, 68),
        DialRotation(RotationDirection.Left, 30),
        DialRotation(RotationDirection.Right, 48),
        DialRotation(RotationDirection.Left, 5),
        DialRotation(RotationDirection.Right, 60),
        DialRotation(RotationDirection.Left, 55),
        DialRotation(RotationDirection.Left, 1),
        DialRotation(RotationDirection.Left, 99),
        DialRotation(RotationDirection.Right, 14),
        DialRotation(RotationDirection.Left, 82)
      )

      // When
      val password: Int = safeService.decipherPassword(rotations, passwordMethod)

      // Then
      assert(password == expectedPassword)
    }
}
