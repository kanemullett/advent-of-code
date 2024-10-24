package petnaest.dva.model

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class CuboidTest {

    @ParameterizedTest
    @CsvSource("2x3x4, 58", "1x1x10, 43")
    fun testShouldCalculateWrappingPaperAccurately(dimensions: String, expectedWrapping: Int) {
        // Given
        val cuboid = Cuboid(dimensions)

        // When
        val wrappingPaper: Int = cuboid.requiredWrappingPaper()

        // Then
        assertEquals(expectedWrapping, wrappingPaper)
    }

    @ParameterizedTest
    @CsvSource("2x3x4, 34", "1x1x10, 14")
    fun testShouldCalculateRibbonLengthAccurately(dimensions: String, expectedRibbon: Int) {
        // Given
        val cuboid = Cuboid(dimensions)

        // When
        val ribbon: Int = cuboid.ribbonLength()

        // Then
        assertEquals(expectedRibbon, ribbon)
    }
}