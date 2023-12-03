class BallPull:
    def __init__(self, pull: str) -> None:
        self.__pull = pull

    def get_red_balls_pulled(self) -> int:
        return self.__split_the_balls()["red"]

    def get_green_balls_pulled(self) -> int:
        return self.__split_the_balls()["green"]

    def get_blue_balls_pulled(self) -> int:
        return self.__split_the_balls()["blue"]

    def __split_the_balls(self) -> dict[str, int]:
        red: int = 0
        green: int = 0
        blue: int = 0

        split_balls: dict[str, int] = {}

        for balls in self.__pull.split(", "):
            number: int = int(balls.split(" ")[0])
            colour: str = balls.split(" ")[1]

            match colour:
                case "red":
                    red = number
                case "green":
                    green = number
                case "blue":
                    blue = number

        split_balls["red"] = red
        split_balls["green"] = green
        split_balls["blue"] = blue

        return split_balls
