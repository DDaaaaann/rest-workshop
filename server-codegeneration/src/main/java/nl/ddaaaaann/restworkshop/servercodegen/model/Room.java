package nl.ddaaaaann.restworkshop.servercodegen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Room {

  private String number;
  private RoomType type;
  private RoomStatus status;
  private Integer capacity;
  private float pricePerNight;

  public enum RoomType {
    SINGLE, DOUBLE, SUITE,
  }

  public enum RoomStatus {
    AVAILABLE, BOOKED,
  }
}
