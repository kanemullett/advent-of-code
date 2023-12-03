package application.aoc2023

import model.BallGame
import utils.TextFileProcessor

class DayTwo {
    private val fileLines = TextFileProcessor(2023, 2).getFileLines()

    fun solvePartA() {
        var idTotal = 0
        for (gameLine in fileLines) {
            val game = BallGame(gameLine, 12, 13, 14)

            if (game.isPossible()) {
                idTotal += game.getGameId()
            }
        }
        println("Part A: $idTotal")
    }

    fun solvePartB() {
        var powerTotal = 0
        for (gameLine in fileLines) {
            val game = BallGame(gameLine, 12, 13, 14)

            powerTotal += game.getGamePowerMinimum()
        }
        println("Part B: $powerTotal")
    }
}


fun main() {
    DayThree().solvePartA()
    DayThree().solvePartB()
}