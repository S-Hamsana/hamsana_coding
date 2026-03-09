package com.hexaware.cricket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponse {

    private UUID playerId;
    private String playerName;
    private Integer jerseyNumber;
    private String role;
    private Integer totalMatches;
    private String teamName;
    private String countryState;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
