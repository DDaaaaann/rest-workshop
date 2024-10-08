package nl.ddaaaaann.restworkshop.servercodegen.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Reservation {

  private Long id;
  private Long guestId;
  private String roomNumber;
  private LocalDate checkIn;
  private LocalDate checkOut;
  private LocalDateTime createdAt;
}
