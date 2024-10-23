package petnaest.jedan.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SantaTest {

    @Test
    fun testMovingUpFloorShouldIncreaseCurrentFloorByOne() {
        // Given
        val santa = Santa()
        val instruction = '('

        // When
        santa.changeFloor(instruction)

        // Then
        assertEquals(1, santa.getCurrentFloor())
    }

    @Test
    fun testMovingDownFloorShouldDecreaseCurrentFloorByOne() {
        // Given
        val santa = Santa()
        val instruction = ')'

        // When
        santa.changeFloor(instruction)

        // Then
        assertEquals(-1, santa.getCurrentFloor())
    }

    @Test
    fun testSubmittingNonParenthesisShouldThrowException() {
        // Given
        val santa = Santa()
        val instruction = '?'

        // When
        val exception: IllegalArgumentException = assertThrows<IllegalArgumentException> {
            santa.changeFloor(instruction)
        }

        // Then
        assertEquals("Movement instruction must be a parenthesis. Provided: ?", exception.message)
    }
}