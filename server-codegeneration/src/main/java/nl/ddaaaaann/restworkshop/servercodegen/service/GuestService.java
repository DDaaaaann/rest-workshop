package nl.ddaaaaann.restworkshop.servercodegen.service;

import java.util.List;
import java.util.Optional;
import nl.ddaaaaann.rest.hotel.model.GuestCreateDto;
import nl.ddaaaaann.rest.hotel.model.GuestUpdateDto;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;

public interface GuestService {

  Guest create(GuestCreateDto guest);

  Guest update(Long guestId, GuestUpdateDto guestDto);

  Optional<Guest> findById(Long id);

  List<Guest> findAll();

  boolean delete(Long id);

  List<Guest> searchByName(String guestName);
}
