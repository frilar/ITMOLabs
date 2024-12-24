package Exception;

public class MissedTrainException extends RuntimeException {
  public MissedTrainException(String name) {
    super(name + " не побежал на станцию и поезд уехал");
  }
}