package nl.ddaaaaann.restworkshop.servercodegen.exception;

public class ReservationNotFoundException extends RuntimeException {

  public ReservationNotFoundException(final Long id) {
    super(String.format("Could not find reservation with id %s", id));
  }
}
