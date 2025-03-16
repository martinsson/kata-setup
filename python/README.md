# Python Project with Pytest

This is a Python project template set up with pytest for testing.

## Setup

1. Create a virtual environment (recommended):
```bash
python -m venv venv
source venv/bin/activate  # On Windows use: venv\Scripts\activate
```

2. Install dependencies and the project in development mode:
```bash
pip install -r requirements.txt
pip install -e .
```

## Running Tests

To run tests:
```bash
pytest
```

To run tests with coverage:
```bash
pytest --cov=src tests/
``` 