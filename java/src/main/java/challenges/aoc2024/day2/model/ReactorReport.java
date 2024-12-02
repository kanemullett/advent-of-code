package challenges.aoc2024.day2.model;

import java.util.List;

import org.immutables.value.Value.Immutable;

@Immutable
public interface ReactorReport {
    
    List<Integer> getLevels();

    static ReactorReport of(String reportLine) {
        
        return ImmutableReactorReport.builder()
            .levels(List.of(reportLine.split(" ")).stream()
                .map(Integer::parseInt)
                .toList())
            .build();
    }
}
