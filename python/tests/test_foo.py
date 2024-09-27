from foo import bar


def test_that_bar_is_true():
    assert bar()


def test_that_bar_is_false():
    assert bar() is False
