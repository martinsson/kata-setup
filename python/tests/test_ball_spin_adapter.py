import pytest
import time
from src.kata.ball_spin_adapter import BallSpinAdapter

class TestBallSpinAdapter:
    def test_it_rolls_for_a_given_amount_of_time(self):
        ball = BallSpinAdapter()
        before = time.time() * 1000  # Convert to milliseconds
        ball.spin()
        after = time.time() * 1000  # Convert to milliseconds
        
        twenty_seconds = 20000
        assert abs(after - before - twenty_seconds) <= 3 