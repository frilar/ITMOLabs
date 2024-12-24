package Exception;

public class IceCreamDepletedException extends Exception {
  @Override
  public String getMessage() {
    return "Не смог съесть мороженое!";
  }
}