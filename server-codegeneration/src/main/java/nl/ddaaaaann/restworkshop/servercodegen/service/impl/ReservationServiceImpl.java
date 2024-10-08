package nl.ddaaaaann.restworkshop.servercodegen.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import nl.ddaaaaann.rest.hotel.model.ReservationCreateDto;
import nl.ddaaaaann.rest.hotel.model.ReservationDto;
import nl.ddaaaaann.restworkshop.servercodegen.exception.ReservationNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.ReservationMapper;
import nl.ddaaaaann.restworkshop.servercodegen.model.Reservation;
import nl.ddaaaaann.restworkshop.servercodegen.service.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

  private final List<Reservation> reservations = new ArrayList<>();
  private final AtomicLong idCounter = new AtomicLong(1);

  @Override
  public Reservation create(final ReservationCreateDto reservationCreateDto) {
    final Reservation newReservation = ReservationMapper.INSTANCE.toEntity(reservationCreateDto);
    newReservation.setId(idCounter.getAndIncrement());
    newReservation.setCreatedAt(LocalDateTime.now());

    reservations.add(newReservation);
    return newReservation;
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
  public Reservation update(final Long id, final ReservationDto reservationDto) {
    return findById(id).map(reservation -> {
      reservation.setId(reservationDto.getId());
      reservation.setGuestId(reservationDto.getGuestId());
      reservation.setRoomNumber(reservationDto.getRoomNumber());
      reservation.setCheckIn(reservationDto.getCheckIn());
      reservation.setCheckOut(reservationDto.getCheckOut());
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
