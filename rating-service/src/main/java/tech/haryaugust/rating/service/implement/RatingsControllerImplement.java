package tech.haryaugust.rating.service.implement;

import tech.haryaugust.rating.service.entity.RatingsEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingsControllerImplement {
    ResponseEntity<RatingsEntity> createRating(RatingsEntity ratingsEntity);

    ResponseEntity<List<RatingsEntity>> getAllRatings();

    ResponseEntity<List<RatingsEntity>> getRatingsByUserId(String id);

    ResponseEntity<List<RatingsEntity>> getRatingsByHotelId(String id);
}
