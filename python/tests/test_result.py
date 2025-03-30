import pytest
from src.kata.result import Result, Color, RouletteException

class TestResult:
    def test_the_37_corresponds_to_00(self):
        result = Result(37)
        assert result.number == "00"

    def test_the_result_is_always_between_00_and_36(self):
        self.assert_number_result(0, "0")
        self.assert_number_result(12, "12")
        self.assert_number_result(36, "36")
        self.assert_number_result(37, "00")

    def test_the_color_of_0_and_00_is_green(self):
        self.assert_color_result(0, Color.GREEN)
        self.assert_color_result(37, Color.GREEN)

    def test_the_color_of_even_numbers_is_black(self):
        self.assert_color_result(2, Color.BLACK)
        self.assert_color_result(14, Color.BLACK)
        self.assert_color_result(36, Color.BLACK)

    def test_the_color_of_odd_numbers_is_red(self):
        self.assert_color_result(1, Color.RED)
        self.assert_color_result(7, Color.RED)
        self.assert_color_result(35, Color.RED)

    def test_it_throws_exception_when_the_randomizer_is_greater_than_37(self):
        with pytest.raises(RouletteException) as exc_info:
            Result(38)
        assert str(exc_info.value) == "Result can't be 38"

    def test_it_throws_exception_when_the_randomizer_is_lesser_than_0(self):
        with pytest.raises(RouletteException) as exc_info:
            Result(-1)
        assert str(exc_info.value) == "Result can't be -1"

    def assert_color_result(self, randomizer_value, expected_color):
        color = Result(randomizer_value).color
        assert color == expected_color

    def assert_number_result(self, randomizer_value, expected_number):
        assert Result(randomizer_value).number == expected_number 