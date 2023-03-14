package tech.haryaugust.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.haryaugust.user.service.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {

}
