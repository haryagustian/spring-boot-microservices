package tech.haryaugust.user.service.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.haryaugust.user.service.entity.RatingsEntity;
import tech.haryaugust.user.service.entity.UsersEntity;
import tech.haryaugust.user.service.implement.UsersControllerImplement;
import tech.haryaugust.user.service.service.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UsersController implements UsersControllerImplement {

    @Autowired
    private UsersService usersService;

    @Override
    @PostMapping
    public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity usersEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.saveUser(usersEntity));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }


    Integer retryCount = 0;
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsersEntity> getSingleUser(@PathVariable("id") String id) {
        log.info("RETRY COUNT : {}", retryCount);
        retryCount++;
        return ResponseEntity.ok(usersService.getUser(id));
    }

    private ResponseEntity<UsersEntity> ratingHotelFallback(String id, Exception exception){
//        log.info("THIS FALLBACK ACTIVE, BECAUSE SERVICE IS DOWN DUDE !!! : {}, {}",exception, exception.getMessage());

        exception.printStackTrace();

        UsersEntity usersEntity = UsersEntity.builder()
                .id(UUID.randomUUID().toString())
                .name("dummy name")
                .email("email@dummy")
                .about("dummy about")
                .ratings(new ArrayList<RatingsEntity>())
                .build();
        return new ResponseEntity<>(usersEntity, HttpStatus.OK);
    }
}
