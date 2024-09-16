package com.example.Laba6.service;

import com.example.Laba6.dto.PlayerDto;
import com.example.Laba6.entity.Player;
import com.example.Laba6.repository.PlayerRepository;
import com.example.Laba6.facade.PlayerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerDto create(PlayerDto playerDto) {
        Player player = PlayerFacade.mapToPlayer(playerDto);
        playerRepository.save(player);
        return PlayerFacade.mapToPlayerDto(player);
    }

    public Boolean delete(String login){
        try {
            playerRepository.delete(playerRepository.findByUserLogin(login).orElseThrow(RuntimeException::new));
            return true;
        } catch (RuntimeException exception) {
            return false;
        }
    }

    public String getLevel(String userLogin){
        return String.valueOf(playerRepository.findByUserLogin(userLogin).get().getLevel());
    }
}
