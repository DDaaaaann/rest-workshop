package nl.ddaaaaann.restworkshop.servercodegen.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import nl.ddaaaaann.restworkshop.servercodegen.exception.ReservationNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.model.Reservation;
import nl.ddaaaaann.restworkshop.servercodegen.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

  private final List<Reservation> reservations = new ArrayList<>();
  private final AtomicLong idCounter = new AtomicLong(1);

  @Override
  public Reservation create(final Reservation reservation) {
    reservation.setId(idCounter.getAndIncrement());
    reservation.setCreatedAt(LocalDateTime.now());

    reservations.add(reservation);
    return reservation;
  }

  @Override
  public Optional<Reservation> findById(final Long id) {
    return reservations.stream()
        .filter((reservation -> reservation.getId().equals(id)))
        .findFirst();
  }

  @Override
  public List<Reservation> findAll() {
    return reservations;
  }

  @Override
  public Reservation update(final Long id, final Reservation updateReservation) {
    return findById(id).map(reservation -> {
      reservation.setGuestId(updateReservation.getGuestId());
      reservation.setRoomNumber(updateReservation.getRoomNumber());
      reservation.setCheckIn(updateReservation.getCheckIn());
      reservation.setCheckOut(updateReservation.getCheckOut());
      return reservation;
    }).orElseThrow(() -> new ReservationNotFoundException(id));
  }

  @Override
  public List<Reservation> findAllByGuest(final Long guestId) {
    return reservations.stream()
        .filter((reservation -> Objects.equals(reservation.getGuestId(), guestId)))
        .toList();
  }

  @Override
  public List<Reservation> findAllByRoom(final String roomNumber) {
    return reservations.stream()
        .filter((reservation -> Objects.equals(reservation.getRoomNumber(), roomNumber)))
        .toList();
  }

  @Override
  public boolean delete(final Long id) {
    return findById(id)
        .map(reservations::remove)
        .orElseThrow();
  }

  @Override
  public List<Reservation> searchByReservationDate(final LocalDate reservationDate) {
    return reservations.stream()
        .filter(reservation -> reservation.getCheckIn().isBefore(reservationDate))
        .filter(reservation -> reservation.getCheckOut().isAfter(reservationDate))
        .toList();
  }
}
