package exception;

public class PointsNotInOrderException extends Exception {

  public PointsNotInOrderException() {
  }

  public PointsNotInOrderException(String message) {
    super(message);
  }
}
