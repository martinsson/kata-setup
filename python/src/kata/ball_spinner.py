from abc import ABC, abstractmethod

class BallSpinner(ABC):
    @abstractmethod
    def spin(self) -> None:
        pass 