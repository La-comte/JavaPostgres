package com.example.Laba6.facade;

import com.example.Laba6.dto.GameDto;
import com.example.Laba6.entity.Game;

public class GameFacade {
    public static Game mapToGame(GameDto GameDto) {
        return new Game(GameDto.getId(), GameDto.getNameGame());
    }

    public static GameDto mapToGameDto(Game Game) {
        return new GameDto(Game.getId(), Game.getNameGame());
    }
}

