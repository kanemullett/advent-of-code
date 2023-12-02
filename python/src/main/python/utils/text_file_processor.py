class TextFileProcessor:
    def __init__(self, year: int, day_number: int) -> None:
        self.__year = year
        self.__day_number = day_number

    def get_file_lines(self) -> list[str]:
        file_location: str = (f"C:\\Users\\Kane Mullett\\advent-of-code\\python\\src\\main\\resources"
                              f"\\aoc{self.__year}\\day{self.__day_number}.txt")
        file = open(file_location, "r")

        return file.readlines()
