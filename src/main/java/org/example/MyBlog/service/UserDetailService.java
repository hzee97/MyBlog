package org.example.MyBlog.service;

import lombok.RequiredArgsConstructor;
import org.example.MyBlog.domain.User;
import org.example.MyBlog.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final or @NotNull 이 붙은 필드의 생성자 추가.
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    // 사용자 email 로 사용자의 정보를 가져오는 메서드.
    @Override
    public User loadUserByUsername(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException((email)));
    }

}
