package com.hexaware.cricket.service;

import com.hexaware.cricket.dto.PlayerRequest;
import com.hexaware.cricket.dto.PlayerResponse;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.PlayerNotFoundException;
import com.hexaware.cricket.repo.PlayerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepo playerRepo;

    @Override
    public List<PlayerResponse> getAllPlayers() {
        return playerRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerResponse getPlayerById(UUID playerId) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));
        return mapToResponse(player);
    }

    @Override
    @Transactional
    public PlayerResponse createPlayer(PlayerRequest request) {
        Player player = mapToEntity(request);
        Player savedPlayer = playerRepo.save(player);
        return mapToResponse(savedPlayer);
    }

    @Override
    @Transactional
    public PlayerResponse updatePlayer(UUID playerId, PlayerRequest request) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException(playerId));

        player.setPlayerName(request.getPlayerName());
        player.setJerseyNumber(request.getJerseyNumber());
        player.setRole(request.getRole());
        player.setTotalMatches(request.getTotalMatches());
        player.setTeamName(request.getTeamName());
        player.setCountryState(request.getCountryState());
        player.setDescription(request.getDescription());

        Player updatedPlayer = playerRepo.save(player);
        return mapToResponse(updatedPlayer);
    }

    @Override
    @Transactional
    public void deletePlayer(UUID playerId) {
        if (!playerRepo.existsById(playerId)) {
            throw new PlayerNotFoundException(playerId);
        }
        playerRepo.deleteById(playerId);
    }

    private Player mapToEntity(PlayerRequest request) {
        Player player = new Player();
        player.setPlayerName(request.getPlayerName());
        player.setJerseyNumber(request.getJerseyNumber());
        player.setRole(request.getRole());
        player.setTotalMatches(request.getTotalMatches() != null ? request.getTotalMatches() : 0);
        player.setTeamName(request.getTeamName());
        player.setCountryState(request.getCountryState());
        player.setDescription(request.getDescription() != null ? request.getDescription() : "");
        return player;
    }

    private PlayerResponse mapToResponse(Player player) {
        return new PlayerResponse(
            player.getPlayerId(),
            player.getPlayerName(),
            player.getJerseyNumber(),
            player.getRole(),
            player.getTotalMatches(),
            player.getTeamName(),
            player.getCountryState(),
            player.getDescription(),
            player.getCreatedAt(),
            player.getUpdatedAt()
        );
    }
}
