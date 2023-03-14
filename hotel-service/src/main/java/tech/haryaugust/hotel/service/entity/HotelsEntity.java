package tech.haryaugust.hotel.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "micro_hotels")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelsEntity {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
