import java.io.File

class AdventUtils {
    companion object {
        fun readInput(year: String, day: String): List<String> {
            return File("./src/main/resources/$year/$day.txt").readLines()
        }
    }
}