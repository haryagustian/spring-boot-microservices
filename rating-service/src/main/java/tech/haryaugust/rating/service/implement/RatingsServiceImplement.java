package tech.haryaugust.rating.service.implement;

import tech.haryaugust.rating.service.entity.RatingsEntity;

import java.util.List;

public interface RatingsServiceImplement {
    RatingsEntity createRating(RatingsEntity ratingsEntity);

    List<RatingsEntity> getAllRatings();

    List<RatingsEntity> getRatingsByUserId(String id);

    List<RatingsEntity> getRatingsByHotelId(String id);
}
