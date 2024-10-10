package nl.ddaaaaann.restworkshop.servercodegen.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import nl.ddaaaaann.rest.hotel.api.GuestApi;
import nl.ddaaaaann.rest.hotel.model.GuestCreateDto;
import nl.ddaaaaann.rest.hotel.model.GuestDto;
import nl.ddaaaaann.rest.hotel.model.GuestUpdateDto;
import nl.ddaaaaann.restworkshop.servercodegen.exception.GuestNotFoundException;
import nl.ddaaaaann.restworkshop.servercodegen.mapper.GuestMapper;
import nl.ddaaaaann.restworkshop.servercodegen.model.Guest;
import nl.ddaaaaann.restworkshop.servercodegen.service.GuestService;
import nl.ddaaaaann.restworkshop.servercodegen.util.LocationUriUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GuestController implements GuestApi {

  private final GuestService guestService;
  private final GuestMapper guestMapper;

  @Override
  public ResponseEntity<Void> createGuest(final GuestCreateDto guestCreateDto) {
    final Guest guestModel = guestMapper.toModel(guestCreateDto);
    final Guest createdGuest = guestService.create(guestModel);

    final URI location = LocationUriUtil.get(createdGuest.getId());

    return created(location).build();
  }

  @Override
  public ResponseEntity<Void> deleteGuestById(final Long guestId) {
    final boolean deleted = guestService.delete(guestId);
    return deleted ? noContent().build() : notFound().build();
  }

  @Override
  public ResponseEntity<GuestDto> getGuestById(final Long guestId) {
    return guestService.findById(guestId)
        .map(guestMapper::toDto)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new GuestNotFoundException(guestId));
  }

  @Override
  public ResponseEntity<List<GuestDto>> getGuests(final String name) {
    final List<GuestDto> guests = guestService.findAll().stream()
        .map(guestMapper::toDto)
        .toList();
    return ok(guests);
  }

  @Override
  public ResponseEntity<GuestDto> updateGuestById(final Long guestId, final GuestUpdateDto guestUpdateDto) {
    final Guest model = guestMapper.toModel(guestUpdateDto);
    final Guest guest = guestService.update(guestId, model);
    return ok(guestMapper.toDto(guest));
  }
}
