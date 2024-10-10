package nl.ddaaaaann.restworkshop.servercodegen.mapper;

import nl.ddaaaaann.rest.hotel.model.ReservationCreateDto;
import nl.ddaaaaann.rest.hotel.model.ReservationDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Reservation;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReservationMapper {
  
  ReservationDto toDto(Reservation model);

  Reservation toModel(ReservationDto dto);

  Reservation toModel(ReservationCreateDto dto);
}
