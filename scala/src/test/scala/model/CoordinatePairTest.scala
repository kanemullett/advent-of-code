package model

import org.scalatest.funsuite.AnyFunSuite

class CoordinatePairTest extends AnyFunSuite {

  test("should build CoordinatePair object from integer coordinates") {
    // When
    val coordinatePair: CoordinatePair = CoordinatePair(2, 3)

    // Then
    assert(coordinatePair.isInstanceOf[CoordinatePair])
    assert(2 == coordinatePair.xCoordinate)
    assert(3 == coordinatePair.yCoordinate)
  }
}
