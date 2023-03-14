package tech.haryaugust.rating.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "micro_ratings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingsEntity {
    @Id
    private String id;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
}
