package model

class Scratchcard(cardNumber: String, winningNumbers: String, userNumbers: String) {
    private val cardNumber: String
    private val winningNumbers: String
    private val userNumbers: String

    init {
        this.cardNumber = cardNumber
        this.winningNumbers = winningNumbers
        this.userNumbers = userNumbers
    }

    fun getCardNumber(): String {
        return cardNumber
    }

    private fun getWinningNumbers(): List<String> {
        return splitNumbersToList(winningNumbers)
    }

    private fun getUserNumbers(): List<String> {
        return splitNumbersToList(userNumbers)
    }

    private fun splitNumbersToList(numbers: String): List<String> {
        return numbers.split(" ").filter { it != "" }
    }

    fun getWinningUserNumbers(): List<String> {
        return getUserNumbers().filter { getWinningNumbers().contains(it) }
    }

    fun getCopyCardNumbers(): List<String> {
        val winningUserNumbers = getWinningUserNumbers().size

        var count = 0

        val copyCardNumbers = mutableListOf<String>()

        while (count < winningUserNumbers) {
            copyCardNumbers.add((cardNumber.toInt() + count + 1).toString())
            count += 1
        }

        return copyCardNumbers
    }
}