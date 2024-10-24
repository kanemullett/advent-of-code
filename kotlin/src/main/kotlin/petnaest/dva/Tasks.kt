package petnaest.dva

import AdventUtils
import petnaest.dva.model.Cuboid

class PartOne {

    companion object {
        private val puzzleInput: List<String> = AdventUtils.readInput("petnaest", "dva")

        @JvmStatic
        fun main(args: Array<String>) {
            val totalWrapping: Int = puzzleInput.map { line -> Cuboid(line) }
                .map(Cuboid::requiredWrappingPaper)
                .sum()

            println(totalWrapping)
        }
    }
}