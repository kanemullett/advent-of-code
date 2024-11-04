package challenges.aoc2023.day2.model;

import org.immutables.value.Value.Immutable;

import java.util.Arrays;
import java.util.List;

@Immutable
public interface BagGame {
    Integer getId();

    List<BallReveal> getReveals();

    static BagGame of(String gameString) {
        final String[] gameStringParts = gameString.split(": ");

        final List<BallReveal> reveals = Arrays.stream(gameStringParts[1].split("; "))
            .map(BallReveal::of)
            .toList();

        return ImmutableBagGame.builder()
            .id(Integer.parseInt(gameStringParts[0].split(" ")[1]))
            .reveals(reveals)
            .build();
    }

    static BagGame of(Integer id, List<BallReveal> reveals) {
        return ImmutableBagGame.builder()
           .id(id)
           .reveals(reveals)
           .build();
    }
}
