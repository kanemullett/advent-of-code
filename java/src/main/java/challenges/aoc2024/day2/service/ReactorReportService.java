package challenges.aoc2024.day2.service;

import java.util.List;

import challenges.aoc2024.day2.function.ReactorSafetyPredicate;
import challenges.aoc2024.day2.model.ReactorReport;

/**
 * Service for performing reactor report safety checks.
 */
public class ReactorReportService {
    
    public ReactorReportService() {
        // Empty constructor for dependency injection
    }

    /**
     * Calculate the total number of reactors whose reported levels are safe.
     * 
     * @param reactorReports The reactor reports to check.
     * @param isProblemDampenerActive True if the reactors have an active problem dampener.
     * 
     * @return The total number of safe reactor reports.
     */
    public Integer calculateTotalSafeReports(List<ReactorReport> reactorReports, boolean isProblemDampenerActive) {
        
        return reactorReports.stream()
            .filter(new ReactorSafetyPredicate(isProblemDampenerActive))
            .toList().size();
    }
}
