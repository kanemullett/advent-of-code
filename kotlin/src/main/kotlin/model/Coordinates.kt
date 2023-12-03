package model

class Coordinates(x: Int, y: Int) {
    private val x: Int
    private val y: Int

    init {
        this.x = x
        this.y = y
    }

    fun getX(): Int {
        return x
    }

    fun getY(): Int {
        return y
    }

    override fun toString(): String {
        return "[$x, $y]"
    }
}