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
public class PlayerDto {
    @Id
    private Long id;
    private String userLogin;
    private int level;
    public PlayerDto(String userLogin){
        this.userLogin = userLogin;
        Random r = new Random();
        level = r.nextInt(9) + 1;
    }
}
