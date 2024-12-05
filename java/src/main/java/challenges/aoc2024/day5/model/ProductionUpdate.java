package challenges.aoc2024.day5.model;

import java.util.List;

import org.immutables.value.Value.Immutable;

@Immutable
public interface ProductionUpdate {
    
    List<Integer> getPages();

    static ProductionUpdate of(String updateString) {
        final List<Integer> pages = List.of(updateString.split(",")).stream()
            .map(Integer::parseInt)
            .toList();

        return ImmutableProductionUpdate.builder()
            .pages(pages)
            .build();
    }
}
