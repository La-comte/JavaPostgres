package com.example.Laba6.repository;

import com.example.Laba6.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Optional<Statistics> findById(Long aLong);

    Optional<Statistics> findByIdPlayer(Long idPlayer);

    Optional<Statistics> findByIdGame(Long idGame);
}
