package nl.ddaaaaann.restworkshop.servercodegen.exception;

public class RoomNotFoundException extends RuntimeException {

  public RoomNotFoundException(final String roomNumber) {
    super(String.format("Could not find room with number %s", roomNumber));
  }
}
