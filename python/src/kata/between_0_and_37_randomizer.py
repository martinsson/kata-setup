from abc import ABC, abstractmethod

class Between0And37Randomizer(ABC):
    @abstractmethod
    def get_roulette_result(self) -> int:
        pass 