package com.hexaware.cricket.service;

import java.util.List;

import com.hexaware.cricketi.dto.PlayerDTO;

public interface IPlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    List<PlayerDTO> getAllPlayers();

    PlayerDTO getPlayerById(int playerId);

    PlayerDTO updatePlayer(int playerId, PlayerDTO playerDTO);

    String deletePlayer(int playerId);
}