package challenges.aoc2024.day5.model;

import java.util.List;

import org.immutables.value.Value.Immutable;

/**
 * ProductionUpdate object containg the pages to be updated.
 */
@Immutable
public interface ProductionUpdate {
    
    /**
     * The pages to be updated.
     * 
     * @return The page numbers.
     */
    List<Integer> getPages();

    /**
     * Build a ProductionUpdate object from an update string.
     * 
     * @param updateString The update string.
     * 
     * @return The ProductionUpdate object.
     */
    static ProductionUpdate of(String updateString) {
        final List<Integer> pages = List.of(updateString.split(",")).stream()
            .map(Integer::parseInt)
            .toList();

        return ImmutableProductionUpdate.builder()
            .pages(pages)
            .build();
    }
}
