package com.example.Laba6.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.util.Random;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StatisticsDto{
    @Id
    private Long id;
    private Long idPlayer;
    private Long idGame;
    private boolean result;
    public StatisticsDto(Long idPlayer, Long idGame) {
        this.idPlayer = idPlayer;
        this.idGame = idGame;
        Random r = new Random();
        result = r.nextBoolean();
    }
}
