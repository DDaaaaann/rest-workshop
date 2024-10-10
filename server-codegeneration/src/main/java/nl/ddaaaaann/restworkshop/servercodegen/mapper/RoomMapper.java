package nl.ddaaaaann.restworkshop.servercodegen.mapper;

import nl.ddaaaaann.rest.hotel.model.RoomDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

  RoomDto toDto(Room model);

}
