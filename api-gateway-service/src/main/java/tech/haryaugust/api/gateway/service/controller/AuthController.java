package tech.haryaugust.api.gateway.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.haryaugust.api.gateway.service.model.AuthResponse;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser oidcUser,
            Model model){

        log.info("USER EMAIL ID : {}", oidcUser.getEmail());

        List<String> authorities = oidcUser
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();

        AuthResponse authResponse = AuthResponse.builder()
                .userId(oidcUser.getEmail())
                .accessToken(client.getAccessToken().getTokenValue())
                .refreshToken(client.getRefreshToken().getTokenValue())
                .expiredAt(client.getAccessToken().getExpiresAt().getEpochSecond())
                .authorities(authorities)
                .build();

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}
