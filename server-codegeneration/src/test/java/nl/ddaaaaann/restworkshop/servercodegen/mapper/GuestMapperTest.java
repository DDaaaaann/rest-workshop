package nl.ddaaaaann.restworkshop.servercodegen.mapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.ddaaaaann.rest.hotel.model.GuestDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class GuestMapperTest {

  private final GuestMapper mapper = Mappers.getMapper(GuestMapper.class);

  @Test
  public void testMapping() {
    Guest guestEntity = new Guest();
    guestEntity.setId(1L);
    guestEntity.setName("John Doe");
    guestEntity.setEmail("john.doe@example.com");

    GuestDto guestDto = mapper.toDto(guestEntity);

    assertEquals(guestEntity.getId(), guestDto.getId());
    assertEquals(guestEntity.getName(), guestDto.getName());
    assertEquals(guestEntity.getEmail(), guestDto.getEmail());
  }
}
