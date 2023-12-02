package utils

import java.io.File

class TextFileProcessor(private val year: Int, private val dayNumber: Int) {

    fun getFileLines(): List<String> {

        val fileLines = ArrayList<String>()

        val fileLocation = "src/main/resources/$year/day$dayNumber.txt"
        val file = File(fileLocation)

        file.forEachLine { fileLines.add(it) }

        return fileLines

    }
}