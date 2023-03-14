package tech.haryaugust.user.service.interceptor;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

@AllArgsConstructor
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        String tokenValue = oAuth2AuthorizedClientManager
                .authorize(
                        OAuth2AuthorizeRequest
                                .withClientRegistrationId("my-internal-client")
                                .principal("internal")
                                .build()
                ).getAccessToken().getTokenValue();

        request.getHeaders().add("Authorization", "Bearer " + tokenValue);

        return execution.execute(request, body);
    }
}
