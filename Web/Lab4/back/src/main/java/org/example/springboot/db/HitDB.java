package org.example.springboot.db;

import org.example.springboot.models.Hit;
import org.example.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface HitDB extends JpaRepository<Hit, Long> {
    Optional<Hit> findHitByUser(User user);
    ArrayList<Hit> findHitsByUser(User user);
}
