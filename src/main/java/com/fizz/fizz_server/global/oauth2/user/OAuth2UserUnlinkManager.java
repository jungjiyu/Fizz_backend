package com.fizz.fizz_server.global.oauth2.user;

import com.fizz.fizz_server.global.oauth2.exception.OAuth2AuthenticationProcessingException;
import com.fizz.fizz_server.global.oauth2.user.google.GoogleOAuth2UserUnlink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OAuth2UserUnlinkManager {
    private final GoogleOAuth2UserUnlink googleOAuth2UserUnlink;

    public void unlink(OAuth2Provider provider, String accessToken) {
        if (OAuth2Provider.GOOGLE.equals(provider)) {
            googleOAuth2UserUnlink.unlink(accessToken);
        }
        // TODO. 다른 것들 추가
        else {
            throw new OAuth2AuthenticationProcessingException("Unlink with " + provider.getRegistrationId() + " is not supported");
        }
    }
}