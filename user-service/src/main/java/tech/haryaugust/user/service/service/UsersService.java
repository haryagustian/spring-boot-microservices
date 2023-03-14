package tech.haryaugust.user.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.haryaugust.user.service.entity.HotelEntity;
import tech.haryaugust.user.service.entity.RatingsEntity;
import tech.haryaugust.user.service.entity.UsersEntity;
import tech.haryaugust.user.service.exception.ResourceNotFoundException;
import tech.haryaugust.user.service.external.service.HotelExternalService;
import tech.haryaugust.user.service.implement.UsersServiceImplement;
import tech.haryaugust.user.service.repository.UsersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsersService implements UsersServiceImplement {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelExternalService hotelExternalService;

    @Override
    public UsersEntity saveUser(UsersEntity usersEntity) {

        return usersRepository.save(UsersEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(usersEntity.getName())
                .email(usersEntity.getEmail())
                .about(usersEntity.getAbout()).build());
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public UsersEntity getUser(String id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given id : [" + id + "] not found from the server dude !!!"));

        RatingsEntity[] forRatingsUserId = restTemplate.getForObject("http://RATINGS-SERVICE/api/v1/ratings/user/" + usersEntity.getId(), RatingsEntity[].class);

        log.info("REST TEMPLATE RESPONSE RATINGS : {}", forRatingsUserId);

        List<RatingsEntity> ratingsEntityList = new ArrayList<>();

        if (forRatingsUserId != null) {
            ratingsEntityList = Arrays.stream(forRatingsUserId).toList();
        }

        usersEntity.setRatings(ratingsEntityList);

//        localhost:8082/api/v1/hotels/e9e6eb40-d08d-44b3-aa0f-def5f04ebad3

        List<RatingsEntity> hotel = ratingsEntityList.stream().map(ratingsEntity -> {

            ResponseEntity<HotelEntity> hotelEntityResponseEntity = restTemplate.getForEntity("http://HOTELS-SERVICE/api/v1/hotels/" + ratingsEntity.getHotelId(), HotelEntity.class);

            log.info("REST TEMPLATE HOTEL RESPONSE : {}", hotelEntityResponseEntity.getStatusCode());

//            HotelEntity hotelEntity = hotelEntityResponseEntity.getBody();

            HotelEntity hotelEntity = hotelExternalService.getHotelById(ratingsEntity.getHotelId());

            ratingsEntity.setHotel(hotelEntity);

            return ratingsEntity;

        }).toList();

        return usersEntity;
    }
}
