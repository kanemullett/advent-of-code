package petnaest.jedan

import AdventUtils

class PartOne {

    companion object {
        private val puzzleInput: String = AdventUtils.readInput("petnaest", "jedan")[0]

        @JvmStatic
        fun main(args: Array<String>) {
            val santa = Santa()

            puzzleInput.split("").forEach { character -> santa.changeFloor(character) }

            println(santa.getCurrentFloor())
        }
    }
}

class PartTwo {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}
