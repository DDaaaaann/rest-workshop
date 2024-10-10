package nl.ddaaaaann.restworkshop.servercodegen.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import nl.ddaaaaann.restworkshop.servercodegen.exception.GuestNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;
import nl.ddaaaaann.restworkshop.servercodegen.service.GuestService;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

  private final List<Guest> guests = new ArrayList<>();
  private final AtomicLong idCounter = new AtomicLong(1);

  @Override
  public List<Guest> findAll() {
    return guests;
  }

  @Override
  public Optional<Guest> findById(final Long id) {
    return guests.stream().filter((guest -> guest.getId().equals(id))).findFirst();
  }

  @Override
  public Guest create(final Guest newGuest) {
    newGuest.setId(idCounter.getAndIncrement());
    newGuest.setCreatedAt(LocalDateTime.now());

    guests.add(newGuest);
    return newGuest;
  }

  @Override
  public boolean delete(final Long id) {
    return findById(id).map(guests::remove).orElseThrow();
  }

  @Override
  public List<Guest> searchByName(final String guestName) {
    return guests.stream().filter((guest -> guest.getName().contains(guestName))).toList();
  }

  @Override
  public Guest update(final Long guestId, final Guest updateGuest) {
    return guests.stream().filter(guest -> Objects.equals(guest.getId(), guestId)).findFirst()
        .map(guest -> {
          if (updateGuest.getName() != null) {
            guest.setName(updateGuest.getName());
          }
          if (updateGuest.getEmail() != null) {
            guest.setEmail(updateGuest.getEmail());
          }
          if (updateGuest.getPhoneNumber() != null) {
            guest.setPhoneNumber(updateGuest.getPhoneNumber());
          }
          return guest;
        }).orElseThrow(() -> new GuestNotFoundException(guestId));
  }
}
