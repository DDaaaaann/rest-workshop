package nl.ddaaaaann.restworkshop.servercodegen.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import nl.ddaaaaann.rest.hotel.api.SearchApi;
import nl.ddaaaaann.rest.hotel.model.GuestDto;
import nl.ddaaaaann.rest.hotel.model.ReservationDto;
import nl.ddaaaaann.rest.hotel.model.RoomDto;
import nl.ddaaaaann.rest.hotel.model.SearchCriteriaDto;
import nl.ddaaaaann.rest.hotel.model.SearchResultsDto;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.GuestMapper;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.ReservationMapper;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.RoomMapper;
import nl.ddaaaaann.restworkshop.servercodegen.service.GuestService;
import nl.ddaaaaann.restworkshop.servercodegen.service.ReservationService;
import nl.ddaaaaann.restworkshop.servercodegen.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController implements SearchApi {

  private final ReservationService reservationService;
  private final ReservationMapper reservationMapper;

  private final RoomService roomService;
  private final RoomMapper roomMapper;

  private final GuestService guestService;
  private final GuestMapper guestMapper;

  @Override
  public ResponseEntity<SearchResultsDto> searchAll(final SearchCriteriaDto searchCriteriaDto) {

    final SearchResultsDto searchResults = new SearchResultsDto();
    final String guestName = searchCriteriaDto.getGuestName();
    final LocalDate reservationDate = searchCriteriaDto.getReservationDate();
    final String roomType = searchCriteriaDto.getRoomType();

    if (guestName != null) {
      final List<GuestDto> guests = guestService.searchByName(guestName).stream()
          .map(guestMapper::toDto)
          .toList();
      searchResults.setGuests(guests);
    }

    if (reservationDate != null) {
      final List<ReservationDto> reservations = reservationService.searchByReservationDate(
              reservationDate).stream()
          .map(reservationMapper::toDto)
          .toList();
      searchResults.setReservations(reservations);
    }

    if (roomType != null) {
      final List<RoomDto> rooms = roomService.searchByRoomType(roomType).stream()
          .map(roomMapper::toDto)
          .toList();
      searchResults.setRooms(rooms);
    }

    return ok(searchResults);
  }
}
