import pytest
from src.kata.java_randomizer_adapter import JavaRandomizerAdapter

class TestJavaRandomizerAdapter:
    @pytest.fixture
    def java_randomizer(self):
        return JavaRandomizerAdapter()

    def test_numbers_are_never_outside_bounds_of_0_and_37(self, java_randomizer):
        results = [java_randomizer.get_roulette_result() for _ in range(10000)]
        assert min(results) == 0
        assert max(results) == 37

    def test_all_numbers_occur(self, java_randomizer):
        results = [java_randomizer.get_roulette_result() for _ in range(10000)]
        unique_results = set(results)
        assert len(unique_results) == 38 