package com.hexaware.cricket.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequest {

    @NotBlank(message = "Player name is required")
    @Size(min = 2, max = 100, message = "Player name must be between 2 and 100 characters")
    private String playerName;

    @NotNull(message = "Jersey number is required")
    @Min(value = 1, message = "Jersey number must be at least 1")
    @Max(value = 999, message = "Jersey number must not exceed 999")
    private Integer jerseyNumber;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder", message = "Role must be Batsman, Bowler, Keeper, or All Rounder")
    private String role;

    @Min(value = 0, message = "Total matches cannot be negative")
    private Integer totalMatches;

    @NotBlank(message = "Team name is required")
    @Size(min = 2, max = 100, message = "Team name must be between 2 and 100 characters")
    private String teamName;

    @NotBlank(message = "Country/State is required")
    @Size(min = 2, max = 100, message = "Country/State must be between 2 and 100 characters")
    private String countryState;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;
}
