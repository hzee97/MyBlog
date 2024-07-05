package org.example.MyBlog.controller.config.jwt;

import io.jsonwebtoken.Jwts;
import org.example.MyBlog.config.jwt.JwtProperties;
import org.example.MyBlog.config.jwt.TokenProvider;
import org.example.MyBlog.domain.User;
import org.example.MyBlog.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProperties jwtProperties;

    // generateToken() 검증 테스트.
    @DisplayName("generateToken() : 유저 정보와 만료 기간을 전달해 토큰 생성.")
    @Test
    void generateToken(){
        //given
        User testUser = userRepository.save(User.builder()
                .email("user@gmail.com")
                .password("test")
                .build());

        //when
        String token = tokenProvider.generateToken(testUser, Duration.ofDays(14));

        //then
        Long userId = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .get("id",Long.class);

        assertThat(userId).isEqualTo(testUser.getId());
    }

}
