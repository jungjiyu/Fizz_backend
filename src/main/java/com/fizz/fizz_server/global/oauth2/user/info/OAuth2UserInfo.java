package com.fizz.fizz_server.global.oauth2.user.info;

import com.fizz.fizz_server.global.oauth2.user.OAuth2Provider;

import java.util.Map;

public interface OAuth2UserInfo {
    OAuth2Provider getProvider();
    String getAccessToken();
    Map<String, Object> getAttributes();
    String getId();
    String getEmail();
    String getName();
    String getFirstName();
    String getLastName();
    String getNickname();
    String getProfileImageUrl();
}
