import pytest
from src.kata.roulette import Roulette
from src.kata.result import Result, Color
from tests.helpers import TestRandomizer, TestBallSpinAdapter

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