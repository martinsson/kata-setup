package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzNoIfTest {

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
        var possibleResults = Arrays.asList(String.valueOf(input), "fizz", "buzz", "fizzbuzz");
        int key = getResultPosition(input);
        return possibleResults.get(key);
    }

    private int getResultPosition(int input) {
        var fizzDivisible = toInt(input % 3 == 0);
        int buzzDivisible = toInt(input % 5 == 0);
        return fizzDivisible + 2 * buzzDivisible;
    }

    private int toInt(boolean bool) {
        return Boolean.compare(bool, false);
    }

}