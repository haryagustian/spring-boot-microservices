package tech.haryaugust.user.service.implement;

import tech.haryaugust.user.service.entity.UsersEntity;

import java.util.List;

public interface UsersServiceImplement {
    UsersEntity saveUser(UsersEntity usersEntity);

    List<UsersEntity> getAllUsers();

    UsersEntity getUser(String id);

}
