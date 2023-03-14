package tech.haryaugust.hotel.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.haryaugust.hotel.service.entity.HotelsEntity;
import tech.haryaugust.hotel.service.exception.ResourceNotFoundException;
import tech.haryaugust.hotel.service.implement.HotelsServiceImplement;
import tech.haryaugust.hotel.service.repository.HotelsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class HotelsService implements HotelsServiceImplement {

    @Autowired
    private HotelsRepository hotelsRepository;

    @Override
    public HotelsEntity createHotel(HotelsEntity hotelsEntity) {
        hotelsEntity = HotelsEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(hotelsEntity.getName())
                .location(hotelsEntity.getLocation())
                .about(hotelsEntity.getAbout()).build();
        return hotelsRepository.save(hotelsEntity);
    }

    @Override
    public List<HotelsEntity> getAllHotels() {
        return hotelsRepository.findAll();
    }

    @Override
    public HotelsEntity getSingleHotel(String id) {
        return hotelsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id : ["+ id + "] not found dude !!!"));
    }
}
