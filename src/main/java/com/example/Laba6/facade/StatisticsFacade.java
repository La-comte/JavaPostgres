package com.example.Laba6.facade;

import com.example.Laba6.dto.StatisticsDto;
import com.example.Laba6.entity.Statistics;

public class StatisticsFacade {
    public static StatisticsDto mapToStatisticsDto(Statistics Statistics) {
        StatisticsDto StatisticsDto = new StatisticsDto(Statistics.getIdPlayer(), Statistics.getIdGame());
        StatisticsDto.setId(Statistics.getId());
        StatisticsDto.setResult(StatisticsDto.isResult());
        return StatisticsDto;
    }

    public static Statistics mapToStatistics(StatisticsDto StatisticsDto) {
        return new Statistics(StatisticsDto.getId(), StatisticsDto.getIdPlayer(), StatisticsDto.getIdGame(), StatisticsDto.isResult());
    }
}
