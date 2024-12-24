package Exception;

public class TooScaredToMoveException extends RuntimeException {
  public TooScaredToMoveException(String name) {
    super(name + " слишком испуган(а), чтобы двигаться!");
  }
}