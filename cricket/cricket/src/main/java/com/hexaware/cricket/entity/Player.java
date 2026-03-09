package com.hexaware.cricket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(name = "jersey_number", nullable = false)
    private Integer jerseyNumber;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "total_matches")
    private Integer totalMatches;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "country_state", nullable = false)
    private String countryState;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
