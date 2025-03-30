import time
from .ball_spinner import BallSpinner

class BallSpinAdapter(BallSpinner):
    DEFAULT_TIME = 20000

    def __init__(self, time_in_milliseconds: int = DEFAULT_TIME):
        self.time_in_milliseconds = time_in_milliseconds

    def spin(self) -> None:
        time.sleep(self.time_in_milliseconds / 1000)  # Convert milliseconds to seconds 