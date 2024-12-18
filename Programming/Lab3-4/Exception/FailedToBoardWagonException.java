package Exception;

public class FailedToBoardWagonException extends RuntimeException {
  public FailedToBoardWagonException(String name) {
    super(name + " не смог(ла) запрыгнуть в вагон на ходу!");
  }
}