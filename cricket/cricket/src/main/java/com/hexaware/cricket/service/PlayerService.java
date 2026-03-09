package com.hexaware.cricket.service;

import com.hexaware.cricket.dto.PlayerRequest;
import com.hexaware.cricket.dto.PlayerResponse;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    List<PlayerResponse> getAllPlayers();

    PlayerResponse getPlayerById(UUID playerId);

    PlayerResponse createPlayer(PlayerRequest request);

    PlayerResponse updatePlayer(UUID playerId, PlayerRequest request);

    void deletePlayer(UUID playerId);
}
