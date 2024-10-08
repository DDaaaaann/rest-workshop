package nl.ddaaaaann.restworkshop.servercodegen.service.impl;

import static nl.ddaaaaann.restworkshop.servercodegen.model.Room.RoomStatus.AVAILABLE;
import static nl.ddaaaaann.restworkshop.servercodegen.model.Room.RoomType.DOUBLE;
import static nl.ddaaaaann.restworkshop.servercodegen.model.Room.RoomType.SINGLE;
import static nl.ddaaaaann.restworkshop.servercodegen.model.Room.RoomType.SUITE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room;
import nl.ddaaaaann.restworkshop.servercodegen.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

  private final List<Room> rooms = new ArrayList<>();

  public RoomServiceImpl() {
    final Room room_101 = Room.of("101", SINGLE, AVAILABLE, 1, 120);
    final Room room_102 = Room.of("102", DOUBLE, AVAILABLE, 2, 140);
    final Room room_103 = Room.of("103", DOUBLE, AVAILABLE, 2, 140);
    final Room room_201 = Room.of("201", SINGLE, AVAILABLE, 1, 120);
    final Room room_202 = Room.of("202", SUITE, AVAILABLE, 2, 180);
    final Room room_203 = Room.of("203", SUITE, AVAILABLE, 2, 180);
    rooms.add(room_101);
    rooms.add(room_102);
    rooms.add(room_103);
    rooms.add(room_201);
    rooms.add(room_202);
    rooms.add(room_203);
  }

  @Override
  public List<Room> findAll() {
    return Collections.unmodifiableList(rooms);
  }

  @Override
  public List<Room> searchByRoomType(final String roomType) {
    return rooms.stream()
        .filter(room -> room.getType().name().equalsIgnoreCase(roomType))
        .toList();
  }

  @Override
  public Optional<Room> findByRoomNumber(final String number) {
    return rooms.stream()
        .filter(room -> Objects.equals(room.getNumber(), number))
        .findFirst();
  }
}
