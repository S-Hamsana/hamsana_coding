package com.hexaware.cricket.controller;

import com.hexaware.cricket.dto.PlayerRequest;
import com.hexaware.cricket.dto.PlayerResponse;
import com.hexaware.cricket.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        List<PlayerResponse> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable UUID playerId) {
        PlayerResponse player = playerService.getPlayerById(playerId);
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> createPlayer(@Valid @RequestBody PlayerRequest request) {
        PlayerResponse player = playerService.createPlayer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerResponse> updatePlayer(
            @PathVariable UUID playerId,
            @Valid @RequestBody PlayerRequest request) {
        PlayerResponse player = playerService.updatePlayer(playerId, request);
        return ResponseEntity.ok(player);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable UUID playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }
}
