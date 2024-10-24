package petnaest.dva.model

class Cuboid(dimensions: String) {
    private val length: Int
    private val height: Int
    private val width: Int

    init {
        val splitDimensions: List<Int> = dimensions.split("x").map { dimension -> dimension.toInt() }
        length = splitDimensions[0]
        height = splitDimensions[1]
        width = splitDimensions[2]
    }

    private fun volume(): Int {
        return length * width * height
    }

    private fun surfaceArea(): Int {
        return 2 * (length * width + length * height + width * height)
    }

    private fun slack(): Int {
        return intArrayOf(length, height, width).sorted().take(2).fold(1) { number1, number2 -> number1 * number2 }
    }

    fun requiredWrappingPaper(): Int {
        return surfaceArea() + slack()
    }

    private fun smallestFacePerimeter(): Int {
        return 2 * intArrayOf(length, height, width).sorted().take(2).sum()
    }

    fun ribbonLength(): Int {
        return volume() + smallestFacePerimeter()
    }
}