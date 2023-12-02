package model

class BallGame(gameLine: String, redBalls: Int, greenBalls: Int, blueBalls: Int) {
    private val gameLine: String
    private val redBalls: Int
    private val greenBalls: Int
    private val blueBalls: Int

    init {
        this.gameLine = gameLine
        this.redBalls = redBalls
        this.greenBalls = greenBalls
        this.blueBalls = blueBalls
    }

    fun getGameId(): Int {
        val gameSection = gameLine.split(": ")[0]

        return gameSection.split(" ")[1].toInt()
    }

    private fun splitTheBalls(): List<BallPull> {
        val ballSection = gameLine.split(": ")[1]

        val pulls = mutableListOf<BallPull>()

        for (ballPull in ballSection.split("; ")) {
            pulls.add(BallPull(ballPull))
        }

        return pulls
    }

    fun isPossible(): Boolean {
        val ballPulls = splitTheBalls()

        for (pull in ballPulls) {
            if (pull.getBlueBallsPulled() > blueBalls || pull.getGreenBallsPulled() > greenBalls || pull.getRedBallsPulled() > redBalls) {
                return false
            }
        }

        return true
    }

    fun getGamePowerMinimum(): Int {
        var redMinimum = 0
        var greenMinimum = 0
        var blueMinimum = 0

        val ballPulls = splitTheBalls()

        for (pull in ballPulls) {
            if (pull.getRedBallsPulled() > redMinimum) {
                redMinimum = pull.getRedBallsPulled()
            }
            if (pull.getGreenBallsPulled() > greenMinimum) {
                greenMinimum = pull.getGreenBallsPulled()
            }
            if (pull.getBlueBallsPulled() > blueMinimum) {
                blueMinimum = pull.getBlueBallsPulled()
            }
        }

        return redMinimum * greenMinimum * blueMinimum
    }
}