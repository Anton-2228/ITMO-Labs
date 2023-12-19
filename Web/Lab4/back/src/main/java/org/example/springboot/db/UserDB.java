package org.example.springboot.db;

import org.example.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDB extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
    boolean existsByLogin(String login);
}
