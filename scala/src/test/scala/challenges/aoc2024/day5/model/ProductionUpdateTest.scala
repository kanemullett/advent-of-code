package challenges.aoc2024.day5.model

import org.scalatest.funsuite.AnyFunSuite

class ProductionUpdateTest extends AnyFunSuite {

  test("should build ProductionUpdate object from string") {
    // When
    val productionUpdate: ProductionUpdate = ProductionUpdate.of("1,23,456")

    // Then
    assert(productionUpdate.isInstanceOf[ProductionUpdate])

    val pages: List[Int] = productionUpdate.pages
    assert(3 == pages.size)
    assert(1 == pages.head)
    assert(23 == pages(1))
    assert(456 == pages(2))
  }
}
