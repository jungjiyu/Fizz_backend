package com.fizz.fizz_server.global.oauth2.user.unlink;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Component
public class KakaoOAuth2UserUnlink implements OAuth2UserUnlink {
    private static final String URL = "https://kapi.kakao.com/v1/user/unlink";
    private final RestTemplate restTemplate;

    @Override
    public void unlink(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);
        HttpEntity<Object> entity = new HttpEntity<>("", httpHeaders);
        restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
    }
}