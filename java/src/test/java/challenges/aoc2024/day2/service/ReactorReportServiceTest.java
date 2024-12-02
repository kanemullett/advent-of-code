package challenges.aoc2024.day2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import challenges.aoc2024.day2.model.ReactorReport;

class ReactorReportServiceTest {
    private ReactorReportService reactorReportService;

    private static final List<ReactorReport> reactorReports = List.of(
        ReactorReport.of("7 6 4 2 1"),
        ReactorReport.of("1 2 7 8 9"),
        ReactorReport.of("9 7 6 2 1"),
        ReactorReport.of("1 3 2 4 5"),
        ReactorReport.of("8 6 4 4 1"),
        ReactorReport.of("1 3 6 7 9")
    );

    @BeforeEach
    void setUp() {
        reactorReportService = new ReactorReportService();
    }

    @ParameterizedTest
    @CsvSource({
        "false, 2",
        "true, 4"
    })
    void shouldCalculateTotalSafeReports(boolean isProblemDampenerActive, Integer expectedSafeReports) {
        // When
        final Integer safeReports = reactorReportService.calculateTotalSafeReports(reactorReports, isProblemDampenerActive);

        // Then
        assertEquals(expectedSafeReports, safeReports);
    }
}
