package nl.ddaaaaann.restworkshop.servercodegen.mapper;

import nl.ddaaaaann.rest.hotel.model.ReservationCreateDto;
import nl.ddaaaaann.rest.hotel.model.ReservationDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ReservationMapper {

  ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

  ReservationDto toDto(Reservation entity);

  Reservation toEntity(ReservationDto dto);

  Reservation toEntity(ReservationCreateDto dto);
}
