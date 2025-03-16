import pytest
from src.calculator import Calculator

def test_add():
    assert Calculator.add(2, 3) == 5
    assert Calculator.add(-1, 1) == 0
    assert Calculator.add(0.1, 0.2) == pytest.approx(0.3)

def test_subtract():
    assert Calculator.subtract(5, 3) == 2
    assert Calculator.subtract(1, 1) == 0
    assert Calculator.subtract(-1, -1) == 0

def test_multiply():
    assert Calculator.multiply(2, 3) == 6
    assert Calculator.multiply(-2, 3) == -6
    assert Calculator.multiply(0, 5) == 0

def test_divide():
    assert Calculator.divide(6, 2) == 3
    assert Calculator.divide(5, 2) == 2.5
    assert Calculator.divide(-6, 2) == -3

def test_divide_by_zero():
    with pytest.raises(ValueError, match="Cannot divide by zero"):
        Calculator.divide(5, 0) 