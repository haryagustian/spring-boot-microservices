package tech.haryaugust.user.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<RatingsEntity> ratings = new ArrayList<>();
}
