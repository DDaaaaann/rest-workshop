package nl.ddaaaaann.restworkshop.servercodegen.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import nl.ddaaaaann.rest.hotel.api.ReservationApi;
import nl.ddaaaaann.rest.hotel.model.ReservationCreateDto;
import nl.ddaaaaann.rest.hotel.model.ReservationDto;
import nl.ddaaaaann.restworkshop.servercodegen.exception.ReservationNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.ReservationMapper;
import nl.ddaaaaann.restworkshop.servercodegen.model.Reservation;
import nl.ddaaaaann.restworkshop.servercodegen.service.ReservationService;
import nl.ddaaaaann.restworkshop.servercodegen.util.LocationUriUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController implements ReservationApi {

  private final ReservationService reservationService;
  private final ReservationMapper reservationMapper;

  @Override
  public ResponseEntity<Void> createReservation(final ReservationCreateDto reservationCreateDto) {
    final Reservation reservationModel = reservationMapper.toModel(reservationCreateDto);
    final Reservation createdReservation = reservationService.create(reservationModel);
    final URI location = LocationUriUtil.get(createdReservation.getId());
    return created(location).build();
  }

  @Override
  public ResponseEntity<Void> deleteReservationById(final Long reservationId) {
    final boolean deleted = reservationService.delete(reservationId);
    return deleted ? noContent().build() : notFound().build();
  }

  @Override
  public ResponseEntity<ReservationDto> getReservationById(final Long reservationId) {
    return reservationService.findById(reservationId)
        .map(reservationMapper::toDto)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new ReservationNotFoundException(reservationId));
  }

  @Override
  public ResponseEntity<List<ReservationDto>> getReservations() {
    final List<ReservationDto> reservations = reservationService.findAll().stream()
        .map(reservationMapper::toDto)
        .toList();
    return ok(reservations);
  }

  @Override
  public ResponseEntity<List<ReservationDto>> getReservationsByGuest(final Long guestId) {
    final List<ReservationDto> reservations = reservationService.findAllByGuest(guestId).stream()
        .map(reservationMapper::toDto)
        .toList();
    return ok(reservations);
  }

  @Override
  public ResponseEntity<List<ReservationDto>> getReservationsByRoom(final String roomNumber) {
    final List<ReservationDto> reservations = reservationService.findAllByRoom(roomNumber).stream()
        .map(reservationMapper::toDto)
        .toList();
    return ok(reservations);
  }

  @Override
  public ResponseEntity<ReservationDto> updateReservationById(final Long reservationId, final ReservationDto reservationDto) {
    final Reservation model = reservationMapper.toModel(reservationDto);
    final Reservation reservation = reservationService.update(reservationId, model);
    return ok(reservationMapper.toDto(reservation));
  }
}
