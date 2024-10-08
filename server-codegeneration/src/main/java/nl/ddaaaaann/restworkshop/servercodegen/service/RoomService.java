package nl.ddaaaaann.restworkshop.servercodegen.service;

import java.util.List;
import java.util.Optional;
import nl.ddaaaaann.restworkshop.servercodegen.model.Room;

public interface RoomService {

  Optional<Room> findByRoomNumber(String number);

  List<Room> findAll();

  List<Room> searchByRoomType(String roomType);
}
