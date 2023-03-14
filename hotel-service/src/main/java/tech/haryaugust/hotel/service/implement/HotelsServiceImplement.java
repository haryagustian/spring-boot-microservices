package tech.haryaugust.hotel.service.implement;

import tech.haryaugust.hotel.service.entity.HotelsEntity;

import java.util.List;

public interface HotelsServiceImplement {
    HotelsEntity createHotel(HotelsEntity hotelsEntity);

    List<HotelsEntity> getAllHotels();

    HotelsEntity getSingleHotel(String id);
}
