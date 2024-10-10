package nl.ddaaaaann.restworkshop.servercodegen.service;

import java.util.List;
import java.util.Optional;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;

public interface GuestService {

  Guest create(Guest createGuest);

  Guest update(Long guestId, Guest updateGuest);

  Optional<Guest> findById(Long id);

  List<Guest> findAll();

  boolean delete(Long id);

  List<Guest> searchByName(String guestName);
}
