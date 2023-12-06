package application.aoc2023

import model.Coordinates
import model.EngineElement
import model.EngineSchematic
import model.types.SchematicPart
import model.types.SchematicPart.DOT
import model.types.SchematicPart.ENGINE_PART
import model.types.SchematicPart.NUMBER
import model.types.SchematicPart.SYMBOL
import utils.TextFileProcessor

class DayThree {
    private val fileLines = TextFileProcessor(2023, 3).getFileLines()
    private val schematic = createSchematic()

    fun solvePartA() {
        val enginePartTotal = calculateEnginePartTotal()

        println("Part A: $enginePartTotal")
    }

    fun solvePartB() {
        val gearRatioTotal = calculateGearRatioTotal()

        println("Part B: $gearRatioTotal")
    }

    private fun createSchematic(): EngineSchematic {
        val schematic = EngineSchematic()
        var row = 0
        for (line in fileLines) {
            convertRow(line, schematic, row)
            row += 1
        }

        convertNumbersToEngineParts(schematic)

        return schematic
    }

    private fun convertRow(line: String, schematic: EngineSchematic, row: Int) {
        val split = line.split("")
        var column = 0
        while (column < split.size) {
            if (column == 0 || column == split.size - 1) {
                column += 1
                continue
            }
            if (split[column] == ".") {
                val position = Coordinates(column - 1, row)
                createAndAddElement(schematic, split[column], DOT, listOf(position))
            } else {
                try {
                    column = convertNumber(split, column, row, schematic)
                } catch (e: IllegalArgumentException) {
                    val position = Coordinates(column - 1, row)
                    createAndAddElement(schematic, split[column], SYMBOL, listOf(position))
                }
            }
            column += 1
        }
    }

    private fun convertNumber(split: List<String>, column: Int, row: Int, schematic: EngineSchematic): Int {
        var col = column

        split[col].toInt()
        val value = StringBuilder(split[col])
        val positions = mutableListOf(Coordinates(col - 1, row))
        while (true) {
            try {
                split[col + 1].toInt()
                col += 1
                value.append(split[col])
                positions.add(Coordinates(col - 1, row))
            } catch (e: IllegalArgumentException) {
                createAndAddElement(schematic, value.toString(), NUMBER, positions)
                break
            }
        }

        return col
    }

    private fun createAndAddElement(schematic: EngineSchematic, value: String, schematicPart: SchematicPart, positions: List<Coordinates>) {
        val element = EngineElement(value, schematicPart, positions)
        schematic.addElement(element)
    }

    private fun convertNumbersToEngineParts(schematic: EngineSchematic) {
        for (number in schematic.getElementsBySchematicPart(NUMBER)) {
            val adjacents = number.getAdjacentPositions()
            for (adjacent in adjacents) {
                if (schematic.getElementByPosition(adjacent)?.getSchematicPart() == SYMBOL) {
                    number.setSchematicPart(ENGINE_PART)
                }
            }
        }
    }

    private fun calculateEnginePartTotal(): Int {
        var enginePartTotal = 0
        for (enginePart in schematic.getElementsBySchematicPart(ENGINE_PART)) {
            enginePartTotal += enginePart.getValue().toInt()
        }

        return enginePartTotal
    }

    private fun calculateGearRatioTotal(): Int {
        var gearRatioTotal = 0

        val asterisks = schematic.getElementsBySchematicPart(SYMBOL)
            .filter { it.getValue() == "*" }

        for (asterisk in asterisks) {
            val adjacentValues = asterisk.getAdjacentPositions()
                .map { schematic.getElementByPosition(it) }
                .distinct()
                .filter { it?.getSchematicPart() == ENGINE_PART }
                .map { it?.getValue()?.toInt() }

            if (adjacentValues.size == 2) {
                gearRatioTotal += (adjacentValues[0] ?: 0) * (adjacentValues[1] ?: 0)
            }
        }

        return gearRatioTotal
    }
}


fun main() {
    DayThree().solvePartA()
    DayThree().solvePartB()
}