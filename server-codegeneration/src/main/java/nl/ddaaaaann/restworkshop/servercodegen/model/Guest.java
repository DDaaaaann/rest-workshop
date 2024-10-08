package nl.ddaaaaann.restworkshop.servercodegen.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Guest {

  private Long id;
  private String name;
  private String email;
  private String phoneNumber;
  private LocalDateTime createdAt;

}
