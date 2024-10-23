import java.io.File

class AdventUtils {
    companion object {
        @JvmStatic
        fun readInput(year: String, day: String): List<String> {
            return File("./src/main/resources/$year/$day.txt").readLines().map { line -> line.trim() }
        }
    }
}