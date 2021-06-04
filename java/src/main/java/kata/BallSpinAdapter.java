package kata;

public class BallSpinAdapter implements BallSpinner {

  private static final int DEFAULT_TIME = 20000;
  private final int timeInMilliseconds;

  public BallSpinAdapter(int timeInMilliseconds) {
    this.timeInMilliseconds = timeInMilliseconds;
  }

  public BallSpinAdapter() {
    this(DEFAULT_TIME);
  }

  @Override
  public void spin() {
    try {
      Thread.sleep(timeInMilliseconds);
    } catch (InterruptedException e) {
    }
  }

}
