package com.example.Laba6.controller;

import com.example.Laba6.dto.StatisticsDto;
import com.example.Laba6.repository.PlayerRepository;
import com.example.Laba6.repository.StatisticsRepository;
import com.example.Laba6.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StatisticsController {
    private final StatisticsService StatisticsService;

    @Autowired
    public StatisticsController(StatisticsService StatisticsService) {
        this.StatisticsService = StatisticsService;
    }

    @PutMapping("createStatPlayer")
    public ResponseEntity<StatisticsDto> create(@RequestBody StatisticsDto StatisticsDto) {
        StatisticsDto StatisticsDto1 = StatisticsService.create(StatisticsDto);
        if (StatisticsDto1 != null)
            return new ResponseEntity<>(StatisticsDto1, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getStatPlayer/{login}")
    public ResponseEntity<List<StatisticsDto>> read(@PathVariable String login) {
        List<StatisticsDto> Statisticss = StatisticsService.read(login);
        if (!Statisticss.isEmpty())
            return new ResponseEntity<>(Statisticss, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}