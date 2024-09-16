package com.example.Laba6.repository;

import com.example.Laba6.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findById(Long aLong);

    Optional<Player> findByUserLogin(String userLogin);
}
