package challenges.aoc2025.day4.model

import model.CoordinatePair
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class WarehouseSpaceTest extends AnyFunSuite {

  val cases: TableFor2[String, Class[?]] = Table(
    ("spaceString", "childClass"),
    ("@", classOf[PaperRoll]),
    (".", classOf[EmptySpace])
  )
  test("should build correct WarehouseSpace child object"):
    forAll(cases) { (spaceString: String, childClass: Class[?]) =>
      // When
      val space: WarehouseSpace = WarehouseSpace.of(spaceString, CoordinatePair(2, 3), 10, 10)

      // Then
      assert(childClass.isInstance(space))

      val adjacent: List[CoordinatePair] = space.adjacentLocations
      assert(adjacent.length == 8)
      assert(adjacent.contains(CoordinatePair(1, 2)))
      assert(adjacent.contains(CoordinatePair(2, 2)))
      assert(adjacent.contains(CoordinatePair(3, 2)))
      assert(adjacent.contains(CoordinatePair(1, 3)))
      assert(adjacent.contains(CoordinatePair(3, 3)))
      assert(adjacent.contains(CoordinatePair(1, 4)))
      assert(adjacent.contains(CoordinatePair(2, 4)))
      assert(adjacent.contains(CoordinatePair(3, 4)))
    }

  test("should only return valid adjacent positions") {
    // When
    val space: PaperRoll = PaperRoll(CoordinatePair(7, 7), 8, 8)

    // Then
    val adjacent: List[CoordinatePair] = space.adjacentLocations
    assert(adjacent.length == 3)
    assert(adjacent.contains(CoordinatePair(6, 6)))
    assert(adjacent.contains(CoordinatePair(7, 6)))
    assert(adjacent.contains(CoordinatePair(6, 7)))
    assert(!adjacent.contains(CoordinatePair(8, 6)))
    assert(!adjacent.contains(CoordinatePair(8, 7)))
    assert(!adjacent.contains(CoordinatePair(6, 8)))
    assert(!adjacent.contains(CoordinatePair(7, 8)))
    assert(!adjacent.contains(CoordinatePair(8, 8)))
  }
}
