package nl.ddaaaaann.restworkshop.servercodegen.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Reservation {

  private Long id;
  private Long guestId;
  private String roomNumber;
  private LocalDate checkIn;
  private LocalDate checkOut;
  private LocalDateTime createdAt;
}
