package kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import kata.Result.Color;
import org.junit.jupiter.api.Test;

public class RouletteAT {
  private Between0And37Randomizer randomizer = mock(Between0And37Randomizer.class);
  private BallSpinAdapter ball = mock(BallSpinAdapter.class);

  @Test
  public void itWaitsForTheBallToStop() {
    Roulette roulette = new Roulette(ball, randomizer);

    roulette.playGame();

    verify(ball).spin();
  }

  @Test()
  public void itProvidesAResultWithColor() throws Exception {
    Between0And37Randomizer randomizer1 = mock(Between0And37Randomizer.class);
    when(randomizer1.getRouletteResult()).thenReturn(0);
    Roulette roulette = new Roulette(ball, randomizer1);

    Result actualResult = roulette.playGame();

    assertEquals("0", actualResult.number);

    assertEquals(Color.GREEN, actualResult.color);
  }

}
