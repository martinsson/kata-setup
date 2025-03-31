import pytest
from src.kata.java_randomizer_adapter import PythonRandomizerAdapter

class TestPythonRandomizerAdapter:
    @pytest.fixture
    def python_randomizer(self):
        return PythonRandomizerAdapter()

    def test_numbers_are_never_outside_bounds_of_0_and_37(self, python_randomizer):
        results = [python_randomizer.get_roulette_result() for _ in range(10000)]
        assert min(results) == 0
        assert max(results) == 37

    def test_all_numbers_occur(self, python_randomizer):
        results = [python_randomizer.get_roulette_result() for _ in range(10000)]
        unique_results = set(results)
        assert len(unique_results) == 38 