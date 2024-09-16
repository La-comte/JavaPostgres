package com.example.Laba6.service;

import com.example.Laba6.dto.GameDto;
import com.example.Laba6.dto.StatisticsDto;
import com.example.Laba6.entity.Player;
import com.example.Laba6.entity.Statistics;
import com.example.Laba6.facade.StatisticsFacade;
import com.example.Laba6.repository.PlayerRepository;
import com.example.Laba6.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StatisticsService {
    @Autowired
    private StatisticsRepository StatisticsRepository;
    @Autowired
    private PlayerRepository PlayerRepository;

    public List<StatisticsDto> read(String login) {
        List<StatisticsDto> StatisticsDtos = new ArrayList<>();
        for (Statistics Statistics : StatisticsRepository.findAll())
            StatisticsDtos.add(StatisticsFacade.mapToStatisticsDto(Statistics));
        for (StatisticsDto i : StatisticsDtos) {
            String loginUser = PlayerRepository.findById(i.getIdPlayer()).get().getUserLogin();
            if (!Objects.equals(loginUser, login)) {
                StatisticsDtos.remove(i);
            }
        }
        return StatisticsDtos;
    }

    public StatisticsDto create(StatisticsDto statisticsDto) {
        Statistics statistics = StatisticsFacade.mapToStatistics(statisticsDto);
        Player player = PlayerRepository.findById(statisticsDto.getIdPlayer()).orElse(null);
        if (player == null)
            return null;
        StatisticsRepository.save(statistics);
        return StatisticsFacade.mapToStatisticsDto(statistics);
    }
}
