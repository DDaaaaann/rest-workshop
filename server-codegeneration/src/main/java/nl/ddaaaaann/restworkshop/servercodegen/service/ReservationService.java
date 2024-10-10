package nl.ddaaaaann.restworkshop.servercodegen.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import nl.ddaaaaann.restworkshop.servercodegen.model.Reservation;

public interface ReservationService {

  Reservation create(Reservation createReservation);

  Reservation update(Long id, Reservation updateReservation);

  Optional<Reservation> findById(Long id);

  List<Reservation> findAll();

  List<Reservation> findAllByGuest(Long guestId);

  List<Reservation> findAllByRoom(String roomNumber);

  boolean delete(Long id);

  List<Reservation> searchByReservationDate(LocalDate reservationDate);
}
