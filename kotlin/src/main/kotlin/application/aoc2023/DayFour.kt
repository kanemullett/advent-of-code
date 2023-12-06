package application.aoc2023

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import model.Scratchcard
import utils.TextFileProcessor
import kotlin.math.pow

class DayFour {
    private val fileLines = TextFileProcessor(2023, 4).getFileLines()
    private val initialScratchcards = createInitialScratchcards()

    fun solvePartA() {
        var total = 0

        for (scratchcard in initialScratchcards) {
            if (scratchcard.getWinningUserNumbers().isNotEmpty()) {
                total += (2.0.pow((scratchcard.getWinningUserNumbers().size - 1).toDouble())).toInt()
            }
        }

        println("Part A: $total")
    }

    fun solvePartB() = runBlocking {
        val copiesMap = mutableMapOf<String, List<String>>()

        for (scratchcard in initialScratchcards) {
            copiesMap[scratchcard.getCardNumber()] = scratchcard.getCopyCardNumbers()
        }

        var cardTotal = 0

        val resultArray = coroutineScope {
            initialScratchcards.map { it.getCardNumber() }.map { n ->
                async { processCardAndItsChildren(n, copiesMap) }
            }.awaitAll()
        }

        resultArray.map { cardTotal += it }

        println("Part B: $cardTotal")
    }

    private fun processCardAndItsChildren(cardNumber: String, copiesMap: Map<String, List<String>>): Int {
        val toProcess = mutableListOf(cardNumber)

        var count = toProcess.size

        while (toProcess.isNotEmpty()) {
            val current = toProcess[0]

            copiesMap[current]?.let { toProcess.addAll(it) }

            toProcess.removeFirst()
            count += copiesMap[current]?.size ?: 0
        }

        return count
    }

    private fun getScratchcard(line: String): Scratchcard {
        val splitCard = line.split(":")

        val cardNumber = splitCard[0].split(" ").filter { it != "" }[1]
        val splitNumbers = splitCard[1].split("|")

        return Scratchcard(cardNumber, splitNumbers[0], splitNumbers[1])
    }

    private fun createInitialScratchcards(): List<Scratchcard> {
        val scratchcards = mutableListOf<Scratchcard>()

        for (line in fileLines) {
            scratchcards.add(getScratchcard(line))
        }

        return scratchcards
    }
}


fun main() {
    DayFour().solvePartA()
    DayFour().solvePartB()
}