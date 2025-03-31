from src.kata.between_0_and_37_randomizer import Between0And37Randomizer
from src.kata.ball_spinner import BallSpinner

class TestRandomizer(Between0And37Randomizer):
    def __init__(self, return_value: int):
        self.return_value = return_value

    def get_roulette_result(self) -> int:
        return self.return_value

class TestBallSpinAdapter(BallSpinner):
    def __init__(self, time_in_milliseconds: int = 0):
        self.time_in_milliseconds = time_in_milliseconds
        self.spin_called = False

    def spin(self) -> None:
        self.spin_called = True
