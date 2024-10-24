package petnaest.jedan

import AdventUtils
import petnaest.jedan.model.Santa

class PartOne {

    companion object {
        private val puzzleInput: String = AdventUtils.readInput("petnaest", "jedan")[0]

        @JvmStatic
        fun main(args: Array<String>) {
            val santa = Santa()

            puzzleInput.toList().forEach { character -> santa.changeFloor(character) }

            println(santa.getCurrentFloor())
        }
    }
}

class PartTwo {

    companion object {
        private val puzzleInput: String = AdventUtils.readInput("petnaest", "jedan")[0]

        @JvmStatic
        fun main(args: Array<String>) {
            val santa = Santa()
            val instructions: List<Char> = puzzleInput.toList()

            var instructionPosition = 0
            while (santa.getCurrentFloor() > -1) {
                // Current instruction has increased
                instructionPosition += 1
                santa.changeFloor(instructions[instructionPosition - 1])
            }

            println(instructionPosition)
        }
    }
}
