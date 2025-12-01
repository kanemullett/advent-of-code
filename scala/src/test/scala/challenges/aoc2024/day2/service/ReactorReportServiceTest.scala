package challenges.aoc2024.day2.service

import challenges.aoc2024.day2.model.ReactorReport
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks.forAll
import org.scalatest.prop.TableFor2
import org.scalatest.prop.Tables.Table

class ReactorReportServiceTest extends AnyFunSuite with BeforeAndAfter {

  private var reactorReportService: ReactorReportService = _

  before {
    reactorReportService = ReactorReportService()
  }

  val cases: TableFor2[Boolean, Int] = Table(
    ("isProblemDampenerActive", "expectedSafeReports"),
    (false, 2),
    (true, 4)
  )
  test("should calculate total safe reports"):
    forAll(cases) { (isProblemDampenerActive: Boolean, expectedSafeReports: Int) =>
      // Given
      val reactorReports: List[ReactorReport] = List(
        ReactorReport.of("7 6 4 2 1"),
        ReactorReport.of("1 2 7 8 9"),
        ReactorReport.of("9 7 6 2 1"),
        ReactorReport.of("1 3 2 4 5"),
        ReactorReport.of("8 6 4 4 1"),
        ReactorReport.of("1 3 6 7 9")
      )

      // When
      val safeReports: Int = reactorReportService.calculateTotalSafeReports(reactorReports, isProblemDampenerActive)

      // Then
      assert(expectedSafeReports == safeReports)
    }
}
