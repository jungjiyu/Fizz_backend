package com.fizz.fizz_server.domain.user.service;

import com.fizz.fizz_server.domain.user.domain.RoleType;
import com.fizz.fizz_server.domain.user.domain.User;
import com.fizz.fizz_server.domain.user.repository.UserRepository;
import com.fizz.fizz_server.global.base.response.exception.BusinessException;
import com.fizz.fizz_server.global.base.response.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void setNicknameAndEmail(Long userId, String nickname, String email) {
        userRepository.findByNickname(nickname)
                .ifPresent(it -> {
                    throw new BusinessException(ExceptionType.DUPLICATED_NICKNAME);
                });

        userRepository.findByEmail(email)
                .ifPresent(it -> {
                    throw new BusinessException(ExceptionType.DUPLICATED_EMAIL);
                });

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));

        user.setNickname(nickname);
        user.setEmail(email);
        user.setRole(RoleType.ROLE_USER);
    }
}