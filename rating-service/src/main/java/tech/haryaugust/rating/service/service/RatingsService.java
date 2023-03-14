package tech.haryaugust.rating.service.service;

import tech.haryaugust.rating.service.entity.RatingsEntity;
import tech.haryaugust.rating.service.implement.RatingsServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.haryaugust.rating.service.repository.RatingsRepository;

import java.util.List;

@Service
public class RatingsService implements RatingsServiceImplement {
    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    public RatingsEntity createRating(RatingsEntity ratingsEntity) {
        return ratingsRepository.save(ratingsEntity);
    }

    @Override
    public List<RatingsEntity> getAllRatings() {
        return ratingsRepository.findAll();
    }

    @Override
    public List<RatingsEntity> getRatingsByUserId(String id) {
        return ratingsRepository.findByUserId(id);
    }

    @Override
    public List<RatingsEntity> getRatingsByHotelId(String id) {
        return ratingsRepository.findByHotelId(id);
    }
}
