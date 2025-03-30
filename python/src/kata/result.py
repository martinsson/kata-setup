from enum import Enum
from .roulette_exception import RouletteException

class Color(Enum):
    GREEN = "GREEN"
    RED = "RED"
    BLACK = "BLACK"

class Result:
    def __init__(self, int_result: int):
        if int_result < 0 or int_result > 37:
            raise RouletteException(f"Result can't be {int_result}")
        self.color = self._calculate_color(int_result)
        self.number = self._calculate_number(int_result)

    def _calculate_number(self, int_result: int) -> str:
        return "00" if int_result == 37 else str(int_result)

    def _calculate_color(self, int_result: int) -> Color:
        if int_result == 0 or int_result == 37:
            return Color.GREEN
        return Color.BLACK if int_result % 2 == 0 else Color.RED 