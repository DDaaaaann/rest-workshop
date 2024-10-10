package nl.ddaaaaann.restworkshop.servercodegen.mapper;

import nl.ddaaaaann.rest.hotel.model.GuestCreateDto;
import nl.ddaaaaann.rest.hotel.model.GuestDto;
import nl.ddaaaaann.rest.hotel.model.GuestUpdateDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GuestMapper {
  
  GuestDto toDto(Guest model);
  
  Guest toModel(GuestCreateDto dto);

  Guest toModel(GuestUpdateDto dto);
}
