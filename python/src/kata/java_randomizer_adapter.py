import random
from .between_0_and_37_randomizer import Between0And37Randomizer

class JavaRandomizerAdapter(Between0And37Randomizer):
    UPPER_LIMIT_FOR_RANDOM_37 = 38
    
    def get_roulette_result(self) -> int:
        return random.randint(0, self.UPPER_LIMIT_FOR_RANDOM_37 - 1) 