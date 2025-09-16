package app.belgarion.tech.expr_eval;

public class DivisionByZeroException extends RuntimeException {
  public DivisionByZeroException(String message) {
    super(message);
  }
}
