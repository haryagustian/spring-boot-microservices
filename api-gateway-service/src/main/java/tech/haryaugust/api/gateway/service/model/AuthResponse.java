package tech.haryaugust.api.gateway.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expiredAt;
    private Collection<String> authorities;
}
