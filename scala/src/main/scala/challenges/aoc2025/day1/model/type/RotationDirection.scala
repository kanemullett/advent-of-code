package challenges.aoc2025.day1.model.`type`

enum RotationDirection:
  case Left, Right

object RotationDirection {

  def of(stringDirection: String): RotationDirection = {

    stringDirection match
      case "L" => RotationDirection.Left
      case "R" => RotationDirection.Right
  }
}