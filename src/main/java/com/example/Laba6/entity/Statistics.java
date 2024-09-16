package com.example.Laba6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@AllArgsConstructor
@Entity
@ToString
@Table(name = "statistics")
public class Statistics {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "id_player", nullable = false)
   private Long idPlayer;

   @Column(name = "id_game", unique = true, nullable = false)
   private Long idGame;

   @Column(name="result", nullable = false)
   private boolean result;

   protected Statistics() {
   }

   public Statistics(Long idPlayer, Long idGame) {
       this.idPlayer = idPlayer;
       this.idGame = idGame;
       Random r = new Random();
       result = r.nextBoolean();
   }
}
