from .ball_spin_adapter import BallSpinAdapter
from .between_0_and_37_randomizer import Between0And37Randomizer
from .result import Result

class Roulette:
    def __init__(self, ball: BallSpinAdapter, randomizer: Between0And37Randomizer):
        self.ball = ball
        self.randomizer = randomizer

    def play_game(self) -> Result:
        self.ball.spin()
        random_result = self.randomizer.get_roulette_result()
        return Result(random_result) 