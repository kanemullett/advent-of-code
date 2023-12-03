package model

import model.types.SchematicPart

class EngineElement(value: String, schematicPart: SchematicPart, positions: List<Coordinates>) {
    private val value: String
    private var schematicPart: SchematicPart
    private val positions: List<Coordinates>

    init {
        this.value = value
        this.schematicPart = schematicPart
        this.positions = positions
    }

    fun getValue(): String {
        return value
    }

    fun getSchematicPart(): SchematicPart {
        return schematicPart
    }

    fun setSchematicPart(schematicPart: SchematicPart) {
        this.schematicPart = schematicPart
    }

    fun getPositions(): List<Coordinates> {
        return positions
    }

    fun getAdjacentPositions(): List<Coordinates> {
        val adjacents = mutableListOf<Coordinates>()

        for (position in positions) {
            val topLeft = Coordinates(position.getX() - 1, position.getY() - 1)
            val above = Coordinates(position.getX(), position.getY() - 1)
            val topRight = Coordinates(position.getX() + 1, position.getY() - 1)
            val right = Coordinates(position.getX() + 1, position.getY())
            val bottomRight = Coordinates(position.getX() + 1, position.getY() + 1)
            val bottom = Coordinates(position.getX(), position.getY() + 1)
            val bottomLeft = Coordinates(position.getX() - 1, position.getY() + 1)
            val left = Coordinates(position.getX() - 1, position.getY())

            val toAdd = listOf(topLeft, above, topRight, right, bottomRight, bottom, bottomLeft, left)

            for (adder in toAdd) {
                if (!adjacents.map { it.toString() }.contains(adder.toString()) && !positions.map { it.toString() }.contains(adder.toString()) && adder.getX() >= 0 && adder.getY() >= 0) {
                    adjacents.add(adder)
                }
            }
        }

        return adjacents
    }
}