package tech.haryaugust.user.service.implement;

import org.springframework.http.ResponseEntity;
import tech.haryaugust.user.service.entity.UsersEntity;

import java.util.List;

public interface UsersControllerImplement {

    ResponseEntity<UsersEntity> createUser(UsersEntity usersEntity);

    ResponseEntity<UsersEntity> getSingleUser(String id);

    ResponseEntity<List<UsersEntity>> getAllUsers();
}
