package model

import model.types.SchematicPart

class EngineSchematic {
    private val elements: MutableList<EngineElement> = mutableListOf()

    fun addElement(element: EngineElement) {
        elements.add(element)
    }

    fun getElementsBySchematicPart(schematicPart: SchematicPart): List<EngineElement> {
        return elements.filter { it.getSchematicPart() == schematicPart }
    }

    fun getElementByPosition(position: Coordinates): EngineElement? {
        for (element in elements) {
            if (element.getPositions().map { it.toString() }.contains(position.toString())) {
                return element
            }
        }
        return null
    }
}