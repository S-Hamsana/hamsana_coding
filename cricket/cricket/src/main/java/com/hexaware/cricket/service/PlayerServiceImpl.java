package com.hexaware.cricket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.repo.PlayerRepository;
import com.hexaware.cricketi.dto.PlayerDTO;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    PlayerRepository repo;

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {

        Player player = convertToEntity(playerDTO);
        Player savedPlayer = repo.save(player);
        return convertToDTO(savedPlayer);
    }

 
    @Override
    public PlayerDTO getPlayerById(int playerId) {

        Player player = repo.findById(playerId).orElse(null);
        if (player == null) {
            return null;
        }
        return convertToDTO(player);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {

        return repo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO updatePlayer(int playerId, PlayerDTO playerDTO) {

        Player player = repo.findById(playerId).orElse(null);

        if (player == null) {
            return null;
        }

        player.setPlayerName(playerDTO.getPlayerName());
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setRole(playerDTO.getRole());
        player.setTotalMatches(playerDTO.getTotalMatches());
        player.setTeamName(playerDTO.getTeamName());
        player.setStateName(playerDTO.getStateName());
        player.setDescription(playerDTO.getDescription());

        Player updatedPlayer = repo.save(player);

        return convertToDTO(updatedPlayer);
    }

    @Override
    public String deletePlayer(int playerId) {

        repo.deleteById(playerId);

        return "Player Deleted Successfully";
    }

    private Player convertToEntity(PlayerDTO dto) {

        Player player = new Player();

        player.setPlayerId(dto.getPlayerId());
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setStateName(dto.getStateName());
        player.setDescription(dto.getDescription());

        return player;
    }

    private PlayerDTO convertToDTO(Player player) {

        PlayerDTO dto = new PlayerDTO();

        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setRole(player.getRole());
        dto.setTotalMatches(player.getTotalMatches());
        dto.setTeamName(player.getTeamName());
        dto.setStateName(player.getStateName());
        dto.setDescription(player.getDescription());

        return dto;
    }
}