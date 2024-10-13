package nl.ddaaaaann.restworkshop.servercodegen.service;

import java.util.List;
import java.util.Optional;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room.RoomType;

public interface RoomService {

  Optional<Room> findByRoomNumber(String number);

  List<Room> findAll();

  List<Room> searchByRoomType(String roomType);

  List<Room> findAllByType(RoomType type);
}
