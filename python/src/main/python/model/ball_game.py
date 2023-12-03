from src.main.python.model.ball_pull import BallPull


class BallGame:
    def __init__(self, game_line: str, red_balls: int, green_balls: int, blue_balls: int) -> None:
        self.__game_line = game_line
        self.__red_balls = red_balls
        self.__green_balls = green_balls
        self.__blue_balls = blue_balls

    def get_game_id(self) -> int:
        game_section: str = self.__game_line.split(": ")[0]

        return int(game_section.split(" ")[1])

    def __split_the_balls(self) -> list[BallPull]:
        ball_section: str = self.__game_line.split(": ")[1]

        pulls: list[BallPull] = []

        for ball_pull in ball_section.split("; "):
            pulls.append(BallPull(ball_pull))

        return pulls

    def is_possible(self) -> bool:
        ball_pulls: list[BallPull] = self.__split_the_balls()

        for pull in ball_pulls:
            if (
                    pull.get_blue_balls_pulled() > self.__blue_balls
                    or pull.get_green_balls_pulled() > self.__green_balls
                    or pull.get_red_balls_pulled() > self.__red_balls
            ):
                return False

        return True

    def get_game_power_minimum(self) -> int:
        red_minimum: int = 0
        green_minimum: int = 0
        blue_minimum: int = 0

        ball_pulls: list[BallPull] = self.__split_the_balls()

        for pull in ball_pulls:
            if pull.get_red_balls_pulled() > red_minimum:
                red_minimum = pull.get_red_balls_pulled()

            if pull.get_green_balls_pulled() > green_minimum:
                green_minimum = pull.get_green_balls_pulled()

            if pull.get_blue_balls_pulled() > blue_minimum:
                blue_minimum = pull.get_blue_balls_pulled()

        return red_minimum * green_minimum * blue_minimum
