package tech.haryaugust.rating.service.repository;

import tech.haryaugust.rating.service.entity.RatingsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends MongoRepository<RatingsEntity, String> {

    List<RatingsEntity> findByUserId(String id);

    List<RatingsEntity> findByHotelId(String id);
}
