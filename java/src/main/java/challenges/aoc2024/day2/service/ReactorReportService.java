package challenges.aoc2024.day2.service;

import java.util.List;

import challenges.aoc2024.day2.function.ReactorSafetyPredicate;
import challenges.aoc2024.day2.model.ReactorReport;

public class ReactorReportService {
    
    public ReactorReportService() {
        // Empty constructor for dependency injection
    }

    public Integer calculateTotalSafeReports(List<ReactorReport> reactorReports) {
        
        return reactorReports.stream()
            .filter(new ReactorSafetyPredicate())
            .toList().size();
    }
}
