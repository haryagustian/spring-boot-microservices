package tech.haryaugust.hotel.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.haryaugust.hotel.service.entity.HotelsEntity;

@Repository
public interface HotelsRepository extends JpaRepository<HotelsEntity, String> {
}
