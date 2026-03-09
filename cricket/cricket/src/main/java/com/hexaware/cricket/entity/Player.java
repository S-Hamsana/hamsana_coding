package com.hexaware.cricket.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="players")
@AllArgsConstructor
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    private String playerName;

    private int jerseyNumber;

    private String role;

    private int totalMatches;

    private String teamName;

    private String stateName;

    private String description;

    
    
    public Player() {}

}





