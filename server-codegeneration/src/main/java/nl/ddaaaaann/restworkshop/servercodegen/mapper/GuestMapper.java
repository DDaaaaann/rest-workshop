package nl.ddaaaaann.restworkshop.servercodegen.mapper;

import nl.ddaaaaann.rest.hotel.model.GuestCreateDto;
import nl.ddaaaaann.rest.hotel.model.GuestDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface GuestMapper {

  GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

  GuestDto toDto(Guest entity);

  Guest toEntity(GuestDto dto);

  Guest toEntity(GuestCreateDto dto);
}
