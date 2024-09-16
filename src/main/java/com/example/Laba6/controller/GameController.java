package com.example.Laba6.controller;

import com.example.Laba6.dto.GameDto;
import com.example.Laba6.dto.PlayerDto;
import com.example.Laba6.repository.PlayerRepository;
import com.example.Laba6.repository.StatisticsRepository;
import com.example.Laba6.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class GameController {
    private final GameService GameService;

    @Autowired
    public GameController(GameService GameService) {
        this.GameService = GameService;
    }

    @GetMapping("getMapPlayer/{login}")
    public ResponseEntity<List<GameDto>> read(@PathVariable String login) {
        List<GameDto> Games = GameService.read(login);
        if (!Games.isEmpty())
            return new ResponseEntity<>(Games, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("createMapPlayer")
    public ResponseEntity<GameDto> create(@RequestBody GameDto GameDto) {
        GameDto GameDto1 = GameService.create(GameDto);
        return new ResponseEntity<>(GameDto1, HttpStatus.CREATED);
    }
}

