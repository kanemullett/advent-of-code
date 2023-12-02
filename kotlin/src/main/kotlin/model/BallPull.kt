package model

class BallPull(pull: String) {
    private val pull: String

    init {
        this.pull = pull
    }

    fun getRedBallsPulled(): Int {
        return splitTheBalls()["red"] ?: 0
    }

    fun getGreenBallsPulled(): Int {
        return splitTheBalls()["green"] ?: 0
    }

    fun getBlueBallsPulled(): Int {
        return splitTheBalls()["blue"] ?: 0
    }

    private fun splitTheBalls(): Map<String, Int> {
        var red = 0
        var green = 0
        var blue = 0

        val splitBalls = mutableMapOf<String, Int>()

        for (balls in pull.split(", ")) {
            val number = balls.split(" ")[0].toInt()
            val colour = balls.split(" ")[1]

            when (colour) {
                "red" -> {
                    red = number
                }
                "green" -> {
                    green = number
                }
                "blue" -> {
                    blue = number
                }
            }
        }

        splitBalls["red"] = red
        splitBalls["green"] = green
        splitBalls["blue"] = blue

        return splitBalls
    }
}