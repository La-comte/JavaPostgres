package com.example.Laba6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Entity
@ToString
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameGame", nullable = false)
    private String nameGame;

    protected Game() {
    }
    public Game(String nameGame) {
        this.nameGame = nameGame;
    }
}