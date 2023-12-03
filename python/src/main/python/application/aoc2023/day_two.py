from src.main.python.model.ball_game import BallGame
from src.main.python.utils.text_file_processor import TextFileProcessor


class DayTwo:
    __file_lines: list[str] = TextFileProcessor(2023, 2).get_file_lines()

    def solve_part_a(self) -> None:
        id_total: int = 0

        for game_line in self.__file_lines:
            game_line = game_line.replace("\n", "")

            game: BallGame = BallGame(game_line, 12, 13, 14)

            if game.is_possible():
                id_total += game.get_game_id()

        print(f"Part A: {id_total}")

    def solve_part_b(self) -> None:
        power_total: int = 0

        for game_line in self.__file_lines:
            game_line = game_line.replace("\n", "")

            game: BallGame = BallGame(game_line, 12, 13, 14)

            power_total += game.get_game_power_minimum()

        print(f"Part B: {power_total}")


if __name__ == "__main__":
    DayTwo().solve_part_a()
    DayTwo().solve_part_b()
