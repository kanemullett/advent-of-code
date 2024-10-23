package petnaest.jedan.model

class Santa() {
    private var currentFloor: Int = 0

    fun getCurrentFloor(): Int {
        return currentFloor
    }

    fun changeFloor(movementInstruction: Char) {
        when (movementInstruction) {
            '(' -> {
                currentFloor += 1
            }
            ')' -> {
                currentFloor -= 1
            }
            else -> {
                throw IllegalArgumentException("Movement instruction must be a parenthesis. Provided: $movementInstruction")
            }
        }
    }
}