package com.example.Laba6.facade;

import com.example.Laba6.dto.PlayerDto;
import com.example.Laba6.entity.Player;

public class PlayerFacade {
    public static PlayerDto mapToPlayerDto(Player player){
        PlayerDto playerDto = new PlayerDto(player.getUserLogin());
        playerDto.setId(player.getId());
        playerDto.setLevel(playerDto.getLevel());
        return playerDto;
    }
    public static Player mapToPlayer(PlayerDto playerDto){
        return new Player(playerDto.getId(), playerDto.getUserLogin(), playerDto.getLevel());
    }
}
