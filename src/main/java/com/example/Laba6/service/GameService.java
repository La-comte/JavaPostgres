package com.example.Laba6.service;

import com.example.Laba6.dto.GameDto;
import com.example.Laba6.entity.Game;
import com.example.Laba6.facade.GameFacade;
import com.example.Laba6.repository.GameRepository;
import com.example.Laba6.repository.PlayerRepository;
import com.example.Laba6.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {
    @Autowired
    private GameRepository GameRepository;
    @Autowired
    private StatisticsRepository StatisticsRepository;
    @Autowired
    private PlayerRepository PlayerRepository;

    public List<GameDto> read(String login) {
        List<GameDto> GameDtos = new ArrayList<>();
        for (Game Game : GameRepository.findAll())
            GameDtos.add(GameFacade.mapToGameDto(Game));
        for (GameDto i : GameDtos) {
            Long playerId = StatisticsRepository.findByIdGame(i.getId()).get().getIdPlayer();
            String loginPlayer = PlayerRepository.findById(playerId).get().getUserLogin();
            if (!Objects.equals(loginPlayer, login)) {
                GameDtos.remove(i);
            }
        }
        return GameDtos;
    }

    public GameDto create(GameDto GameDto) {
        Game Game = GameFacade.mapToGame(GameDto);
        GameRepository.save(Game);
        return GameFacade.mapToGameDto(Game);
    }
}
