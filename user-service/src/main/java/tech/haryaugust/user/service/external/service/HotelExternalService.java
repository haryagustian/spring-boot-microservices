package tech.haryaugust.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.haryaugust.user.service.entity.HotelEntity;

@FeignClient(name = "HOTELS-SERVICE/api/v1/hotels")
public interface HotelExternalService {

    @GetMapping("/{id}")
    HotelEntity getHotelById(@PathVariable("id") String id);
}
