package applications.aoc2023

import model.Calibrator
import model.types.QuestionPart
import model.types.QuestionPart.PART_A
import model.types.QuestionPart.PART_B
import utils.TextFileProcessor

class DayOne {
    private val fileLines = TextFileProcessor(2023, 1).getFileLines()

    fun solvePartA() {
        println("Part A: ${getCalibrationTotal(PART_A)}")
    }

    fun solvePartB() {
        println("Part B: ${getCalibrationTotal(PART_B)}")
    }

    private fun getCalibrationTotal(questionPart: QuestionPart): Int {
        var answer = 0
        for (line in fileLines) {
            val calibrator = Calibrator(line, questionPart)

            val calibrationValue = calibrator.getCalibrationValue()

            answer += calibrationValue
        }

        return answer
    }
}


fun main() {
    DayOne().solvePartA()
    DayOne().solvePartB()
}