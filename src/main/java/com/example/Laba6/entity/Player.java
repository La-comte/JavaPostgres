package com.example.Laba6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@ToString
@AllArgsConstructor
@Table(name = "players")
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "level", nullable = false)
    private int level;

    protected Player() {
    }

    public Player(User user) {
        this.userLogin = user.getLogin();
        Random r = new Random();
        level = r.nextInt(9)+1;
    }
}