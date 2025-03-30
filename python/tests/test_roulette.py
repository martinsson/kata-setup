import pytest
from src.kata.roulette import Roulette
from src.kata.result import Result, Color
from src.kata.between_0_and_37_randomizer import Between0And37Randomizer

class TestRandomizer(Between0And37Randomizer):
    def __init__(self, return_value: int):
        self.return_value = return_value

    def get_roulette_result(self) -> int:
        return self.return_value

class TestBallSpinAdapter:
    def __init__(self, time_in_milliseconds: int = 0):
        self.time_in_milliseconds = time_in_milliseconds
        self.spin_called = False

    def spin(self) -> None:
        self.spin_called = True
        # No actual sleep in test implementation

class TestRoulette:
    @pytest.fixture
    def randomizer(self):
        return TestRandomizer(0)  # Default to returning 0

    @pytest.fixture
    def ball(self):
        return TestBallSpinAdapter(time_in_milliseconds=100)

    def test_it_waits_for_the_ball_to_stop(self, ball, randomizer):
        roulette = Roulette(ball, randomizer)
        roulette.play_game()
        assert ball.spin_called

    def test_it_provides_a_result_with_color(self, ball, randomizer):
        roulette = Roulette(ball, randomizer)
        actual_result = roulette.play_game()
        assert actual_result.number == "0"
        assert actual_result.color == Color.GREEN 