package com.hexaware.cricket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exception.ResourceNotFoundException;
import com.hexaware.cricket.repo.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

   
    public List<PlayerDTO> getAllPlayers(){

        List<Player> players = repo.findAll();
        List<PlayerDTO> dtoList = new ArrayList<>();

        for(Player p : players){

            PlayerDTO dto = new PlayerDTO();

            dto.setPlayerId(p.getPlayerId());
            dto.setPlayerName(p.getPlayerName());
            dto.setJerseyNumber(p.getJerseyNumber());
            dto.setRole(p.getRole());
            dto.setTotalMatches(p.getTotalMatches());
            dto.setTeamName(p.getTeamName());
            dto.setCountry(p.getCountry());
            dto.setDescription(p.getDescription());

            dtoList.add(dto);
        }

        return dtoList;
    }

   
    public PlayerDTO getPlayerById(Long id){

        Player p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));

        if(p == null){
            return null;
        }

        PlayerDTO dto = new PlayerDTO();

        dto.setPlayerId(p.getPlayerId());
        dto.setPlayerName(p.getPlayerName());
        dto.setJerseyNumber(p.getJerseyNumber());
        dto.setRole(p.getRole());
        dto.setTotalMatches(p.getTotalMatches());
        dto.setTeamName(p.getTeamName());
        dto.setCountry(p.getCountry());
        dto.setDescription(p.getDescription());

        return dto;
    }

    
    public PlayerDTO addPlayer(PlayerDTO dto){

        Player p = new Player();

        p.setPlayerName(dto.getPlayerName());
        p.setJerseyNumber(dto.getJerseyNumber());
        p.setRole(dto.getRole());
        p.setTotalMatches(dto.getTotalMatches());
        p.setTeamName(dto.getTeamName());
        p.setCountry(dto.getCountry());
        p.setDescription(dto.getDescription());

        Player saved = repo.save(p);

        dto.setPlayerId(saved.getPlayerId());

        return dto;
    }

   
    public PlayerDTO updatePlayer(Long id, PlayerDTO dto){

        Player p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));

        if(p == null){
            return null;
        }

        p.setPlayerName(dto.getPlayerName());
        p.setJerseyNumber(dto.getJerseyNumber());
        p.setRole(dto.getRole());
        p.setTotalMatches(dto.getTotalMatches());
        p.setTeamName(dto.getTeamName());
        p.setCountry(dto.getCountry());
        p.setDescription(dto.getDescription());

        repo.save(p);

        dto.setPlayerId(id);

        return dto;
    }

    
    public void deletePlayer(Long id){

        Player player = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id " + id));

        repo.delete(player);
    }

}