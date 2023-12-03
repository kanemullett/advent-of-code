from src.main.python.model.types.question_part import QuestionPart
from src.main.python.model.calibrator import Calibrator
from src.main.python.utils.text_file_processor import TextFileProcessor


class DayOne:
    __file_lines = TextFileProcessor(2023, 1).get_file_lines()

    def solve_part_a(self) -> None:
        print(f"Part A: {self.__get_calibration_total(QuestionPart.PART_A)}")

    def solve_part_b(self) -> None:
        print(f"Part B: {self.__get_calibration_total(QuestionPart.PART_B)}")

    def __get_calibration_total(self, question_part: QuestionPart) -> int:
        answer: int = 0
        for line in self.__file_lines:
            calibrator: Calibrator = Calibrator(line, question_part)

            calibration_value: int = calibrator.get_calibration_value()

            answer += calibration_value

        return answer


if __name__ == "__main__":
    DayOne().solve_part_a()
    DayOne().solve_part_b()
