package tech.haryaugust.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingsEntity {
    private String id;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
    private HotelEntity hotel;

}
