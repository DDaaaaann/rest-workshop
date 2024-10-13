package nl.ddaaaaann.restworkshop.servercodegen.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import nl.ddaaaaann.rest.hotel.api.RoomApi;
import nl.ddaaaaann.rest.hotel.model.RoomDto;
import nl.ddaaaaann.restworkshop.servercodegen.exception.RoomNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.RoomMapper;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room.RoomType;
import nl.ddaaaaann.restworkshop.servercodegen.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {

  private final RoomService roomService;
  private final RoomMapper roomMapper;

  @Override
  public ResponseEntity<RoomDto> getRoomByNumber(final String roomNumber) {
    return roomService.findByRoomNumber(roomNumber)
        .map(roomMapper::toDto)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new RoomNotFoundException(roomNumber));
  }

  @Override
  public ResponseEntity<List<RoomDto>> getRooms(final String type) {
    final List<Room> rooms;
    if (type != null) {
      final RoomType roomType = RoomType.valueOf(type.toUpperCase());
      rooms = roomService.findAllByType(roomType);
    } else {
      rooms = roomService.findAll();
    }

    final List<RoomDto> roomDtos = rooms.stream()
        .map(roomMapper::toDto)
        .collect(Collectors.toList());

    return ResponseEntity.ok(roomDtos);
  }
}
