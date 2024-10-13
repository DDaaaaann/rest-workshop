package nl.ddaaaaann.restworkshop.servercodegen.controller;

import nl.ddaaaaann.restworkshop.servercodegen.exception.GuestNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.exception.ReservationNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.exception.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
      GuestNotFoundException.class,
      ReservationNotFoundException.class,
      RoomNotFoundException.class
  })
  public ResponseEntity<String> handleNotFoundException(GuestNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(ex.getMessage());
  }

  @ExceptionHandler({
      IllegalArgumentException.class
  })
  public ResponseEntity<String> badRequestException(IllegalArgumentException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ex.getMessage());
  }
}