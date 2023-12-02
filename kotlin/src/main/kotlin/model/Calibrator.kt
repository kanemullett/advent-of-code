package model

import model.types.QuestionPart
import model.types.QuestionPart.PART_B
import java.lang.IllegalArgumentException

class Calibrator(line: String, questionPart: QuestionPart) {
    private val line: String
    private val questionPart: QuestionPart

    init {
        this.line = line
        this.questionPart = questionPart
    }

    private fun getNumbersFromLine(): Map<Int, String> {
        val numberTranslations = mapOf(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )

        val numberPositions = mutableMapOf<Int, String>()

        if (questionPart == PART_B) {
            for (textNumber in numberTranslations.keys) {
                val indices = Regex(textNumber, RegexOption.IGNORE_CASE).findAll(line)
                    .map { it.range.first }
                    .toList()

                for (index in indices) {
                    numberPositions[index] = numberTranslations[textNumber].toString()
                }
            }
        }

        for (i in line.indices) {
            try {
                line[i].digitToInt()
                numberPositions[i] = line[i].toString()
            } catch (e: IllegalArgumentException) {
                continue
            }
        }

        return numberPositions
    }

    fun getCalibrationValue(): Int {
        val numbersInLine = getNumbersFromLine()

        val sortedKeys = numbersInLine.keys.sorted()

        val calibrationValue = numbersInLine[sortedKeys[0]] + numbersInLine[sortedKeys[sortedKeys.size - 1]]

        return calibrationValue.toInt()
    }
}