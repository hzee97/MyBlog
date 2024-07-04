package org.example.MyBlog.repository;

import org.example.MyBlog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // email 로 사용자 정보 가져옴.
}
