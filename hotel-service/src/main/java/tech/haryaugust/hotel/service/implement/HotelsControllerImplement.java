package tech.haryaugust.hotel.service.implement;

import org.springframework.http.ResponseEntity;
import tech.haryaugust.hotel.service.entity.HotelsEntity;

import java.util.List;

public interface HotelsControllerImplement {
    ResponseEntity<HotelsEntity> createHotel(HotelsEntity hotelsEntity);

    ResponseEntity<HotelsEntity> getSingleHotel(String id);

    ResponseEntity<List<HotelsEntity>> getAllHotels();
}
