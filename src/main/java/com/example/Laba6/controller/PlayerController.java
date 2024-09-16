package com.example.Laba6.controller;

import com.example.Laba6.dto.PlayerDto;
import com.example.Laba6.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PutMapping("createPlayerByLogin")
    public ResponseEntity<PlayerDto> create(@RequestBody PlayerDto playerDto){
        PlayerDto playerDto1 = playerService.create(playerDto);
        return new ResponseEntity<>(playerDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("deletePlayer/{login}")
    public ResponseEntity<Boolean> delete(@PathVariable String login){
        Boolean delete = playerService.delete(login);
        if(delete){
            return new ResponseEntity<>(delete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(delete, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("getPlayer/{login}")
    public ResponseEntity<String> get(@PathVariable String login){
        String level =  playerService.getLevel(login);
        if (!level.isEmpty()){
            return new ResponseEntity<>(("Level: " + level), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
