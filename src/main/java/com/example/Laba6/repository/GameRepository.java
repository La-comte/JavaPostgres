package com.example.Laba6.repository;

import com.example.Laba6.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findById(Long id);

    Optional<Game> findByNameGame(String nameGame);
}

