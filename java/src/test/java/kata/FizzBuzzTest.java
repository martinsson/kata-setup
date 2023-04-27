package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource(value = {
            "3, fizz",
            "6, fizz",
            "9, fizz",
            "5, buzz",
            "10, buzz",
            "15, fizzbuzz",
            "30, fizzbuzz",
    })
    void fizzbuzz(int input, String result) {
        assertThat(fizzbuzz(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints={1, 2, 4, 7, 22, 98})
    void normal_numbers(int input) {
        assertThat(fizzbuzz(input)).isEqualTo(String.valueOf(input));
    }

    private String fizzbuzz(int input) {
        if (input % 15 == 0) {
            return "fizzbuzz";
        }
        if (input % 5 == 0) {
            return "buzz";
        }
        if (input % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(input);
    }
}
