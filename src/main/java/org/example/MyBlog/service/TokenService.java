package org.example.MyBlog.service;

import lombok.RequiredArgsConstructor;
import org.example.MyBlog.config.jwt.TokenProvider;
import org.example.MyBlog.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;

    public String createNewAccessToken(String refreshToken){

        // 토큰 유효성 검사.
        if (!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();

        User user = userService.findByid(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(1));
    }
}
