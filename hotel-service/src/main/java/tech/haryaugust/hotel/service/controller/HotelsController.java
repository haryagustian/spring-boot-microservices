package tech.haryaugust.hotel.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.haryaugust.hotel.service.entity.HotelsEntity;
import tech.haryaugust.hotel.service.implement.HotelsControllerImplement;
import tech.haryaugust.hotel.service.service.HotelsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelsController implements HotelsControllerImplement {

    @Autowired
    private HotelsService hotelsService;

    @PreAuthorize("hasAuthority('Admin')")
    @Override
    @PostMapping
    public ResponseEntity<HotelsEntity> createHotel(@RequestBody HotelsEntity hotelsEntity) {
        return ResponseEntity.ok(hotelsService.createHotel(hotelsEntity));
    }

    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<HotelsEntity> getSingleHotel(@PathVariable("id") String id) {
        return ResponseEntity.ok(hotelsService.getSingleHotel(id));
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @Override
    @GetMapping
    public ResponseEntity<List<HotelsEntity>> getAllHotels() {
        return ResponseEntity.ok(hotelsService.getAllHotels());
    }
}
