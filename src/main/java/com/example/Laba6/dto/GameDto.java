package com.example.Laba6.dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GameDto {
    @Id
    private Long id;
    private String nameGame;
}