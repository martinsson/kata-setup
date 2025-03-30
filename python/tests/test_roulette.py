import pytest
from unittest.mock import Mock, patch
from src.kata.roulette import Roulette
from src.kata.result import Result, Color

class TestRoulette:
    @pytest.fixture
    def randomizer(self):
        return Mock()

    @pytest.fixture
    def ball(self):
        return Mock()

    def test_it_waits_for_the_ball_to_stop(self, ball, randomizer):
        randomizer.get_roulette_result.return_value = 0  # Set a default return value
        roulette = Roulette(ball, randomizer)
        roulette.play_game()
        ball.spin.assert_called_once()

    def test_it_provides_a_result_with_color(self, ball, randomizer):
        randomizer.get_roulette_result.return_value = 0
        roulette = Roulette(ball, randomizer)
        actual_result = roulette.play_game()
        assert actual_result.number == "0"
        assert actual_result.color == Color.GREEN 