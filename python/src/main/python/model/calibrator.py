from src.main.python.model.types.question_part import QuestionPart


class Calibrator:
    def __init__(self, line: str, question_part: QuestionPart) -> None:
        self.__line = line
        self.__question_part = question_part

    def __get_numbers_from_line(self) -> dict[int, str]:
        number_translations: dict[str, str] = {
            "zero": "0",
            "one": "1",
            "two": "2",
            "three": "3",
            "four": "4",
            "five": "5",
            "six": "6",
            "seven": "7",
            "eight": "8",
            "nine": "9",
        }

        number_positions: dict[int, str] = {}

        if self.__question_part == QuestionPart.PART_B:
            for text_number in list(number_translations.keys()):
                indices: list[int] = [i for i in range(len(self.__line)) if self.__line.startswith(text_number, i)]

                for index in indices:
                    number_positions[index] = number_translations[text_number]

        count: int = 0

        while count < len(self.__line):
            try:
                int(self.__line[count])
                number_positions[count] = self.__line[count]
            except ValueError:
                pass

            count += 1

        return number_positions

    def get_calibration_value(self) -> int:
        numbers_in_line: dict[int, str] = self.__get_numbers_from_line()

        keys: list[int] = list(numbers_in_line.keys())

        keys.sort()

        calibration_value = numbers_in_line[keys[0]] + numbers_in_line[keys[len(keys) - 1]]

        return int(calibration_value)
