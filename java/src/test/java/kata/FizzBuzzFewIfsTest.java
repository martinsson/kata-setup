package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzFewIfsTest {

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
        Map<Integer, Function<Integer, String>> cases = new HashMap<>() {{
            put(0, String::valueOf);
            put(1, i -> "fizz");
            put(2, i -> "buzz");
            put(3, i -> "fizzbuzz");
        }};
        var fizzDivisible = input % 3 == 0;
        var buzzDivisible = input % 5 == 0;
        var key = toInt(fizzDivisible) + 2 * toInt(buzzDivisible);
        return cases.get(key).apply(input);
    }

    private int toInt(boolean bool) {
        return Boolean.compare(bool, false);
    }

    private int isDivisible(int divisisor, int number) {
        return number % divisisor == 0 ? 1 : 0;
    }
}
