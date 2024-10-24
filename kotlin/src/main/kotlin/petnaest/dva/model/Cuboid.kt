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

    private fun surfaceArea(): Int {
        return 2 * (length * width + length * height + width * height)
    }

    private fun slack(): Int {
        return intArrayOf(length, height, width).sorted().take(2).fold(1) { number1, number2 -> number1 * number2 }
    }

    fun requiredWrappingPaper(): Int {
        return surfaceArea() + slack()
    }
}