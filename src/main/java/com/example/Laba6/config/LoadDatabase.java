package com.example.Laba6.config;

import com.example.Laba6.entity.Game;
import com.example.Laba6.entity.Player;
import com.example.Laba6.entity.Statistics;
import com.example.Laba6.entity.User;
import com.example.Laba6.repository.GameRepository;
import com.example.Laba6.repository.StatisticsRepository;
import com.example.Laba6.repository.UserRepository;
import com.example.Laba6.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PlayerRepository playerRepository, StatisticsRepository statisticsRepository, GameRepository gameRepository) {
        return args -> {
            log.info("Preloading {}", userRepository.save(new User("diorka")));
            User mew = new User("mew");
            log.info("Preloading {}", userRepository.save(mew));
            Player kitty = new Player(mew);
            log.info("Preloading {}", playerRepository.save(kitty));
            Statistics kittyStat = new Statistics(kitty.getId(), 1L);
            log.info("Preloading {}", statisticsRepository.save(kittyStat));
            Statistics kittyStat2 = new Statistics(kitty.getId(), 2L);
            log.info("Preloading {}", statisticsRepository.save(kittyStat2));
            Game kittyGame = new Game(kittyStat.getIdGame(), "Kitty first game");
            log.info("Preloading {}", gameRepository.save(kittyGame));
        };
    }
}
