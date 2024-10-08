package nl.ddaaaaann.restworkshop.servercodegen.exception;

public class GuestNotFoundException extends RuntimeException {

  public GuestNotFoundException(final Long id) {
    super(String.format("Could not find guest with id %s", id));
  }
}
