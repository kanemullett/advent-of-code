package challenges.aoc2024.day2.model;

import java.util.List;

import org.immutables.value.Value.Immutable;

/**
 * ReactorReport object containing the reactor's reported levels.
 */
@Immutable
public interface ReactorReport {
    
    /**
     * The reactor's reported levels.
     * 
     * @return List of reported levels.
     */
    List<Integer> getLevels();

    /**
     * Build a ReactorReport object from the given report line.
     * 
     * @param reportLine The raw line of the report.
     * 
     * @return ReactorReport object.
     */
    static ReactorReport of(String reportLine) {
        
        return ImmutableReactorReport.builder()
            .levels(List.of(reportLine.split(" ")).stream()
                .map(Integer::parseInt)
                .toList())
            .build();
    }
}
