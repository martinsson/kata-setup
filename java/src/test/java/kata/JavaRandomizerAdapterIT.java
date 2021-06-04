package kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

public class JavaRandomizerAdapterIT {

	private JavaRandomizerAdapter javaRandomizer = new JavaRandomizerAdapter();

	@Test
	public void numbersAreNeverOutsideBoundsOf0And37() throws Exception {
		assertThat(generateResults().min().getAsInt()).isEqualTo(0);
		assertThat(generateResults().max().getAsInt()).isEqualTo(37);
	}

	@Test
	public void allNumbersOccur() throws Exception {
		IntStream uniqueResults = generateResults().distinct();
		assertThat(uniqueResults).size().isEqualTo(38);
	}

	private IntStream generateResults() {
		return IntStream.range(0, 10000).map(i -> javaRandomizer.getRouletteResult());
	}

}
