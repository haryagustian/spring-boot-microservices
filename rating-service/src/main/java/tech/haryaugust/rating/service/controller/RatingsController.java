package tech.haryaugust.rating.service.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import tech.haryaugust.rating.service.entity.RatingsEntity;
import tech.haryaugust.rating.service.implement.RatingsControllerImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.haryaugust.rating.service.service.RatingsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsController implements RatingsControllerImplement {
    
    @Autowired
    private RatingsService ratingsService;

    @PreAuthorize("hasAuthority('Admin')")
    @Override
    @PostMapping
    public ResponseEntity<RatingsEntity> createRating(@RequestBody RatingsEntity ratingsEntity) {
        return ResponseEntity.ok(ratingsService.createRating(ratingsEntity));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RatingsEntity>> getAllRatings() {
        return ResponseEntity.ok(ratingsService.getAllRatings());
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @Override
    @GetMapping("/user/{id}")
    public ResponseEntity<List<RatingsEntity>> getRatingsByUserId(@PathVariable("id") String id) {
        return ResponseEntity.ok(ratingsService.getRatingsByUserId(id));
    }

    @Override
    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<RatingsEntity>> getRatingsByHotelId(@PathVariable("id") String id) {
        return ResponseEntity.ok(ratingsService.getRatingsByHotelId(id));
    }
}
