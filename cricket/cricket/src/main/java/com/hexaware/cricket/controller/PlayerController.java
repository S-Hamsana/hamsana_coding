package com.hexaware.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cricket.dto.PlayerDTO;
import com.hexaware.cricket.service.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping
    public List<PlayerDTO> getAllPlayers(){
        return service.getAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id){
        return service.getPlayerById(id);
    }

    @PostMapping
    public PlayerDTO addPlayer(@RequestBody PlayerDTO dto){
        return service.addPlayer(dto);
    }

    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id,@RequestBody PlayerDTO dto){
        return service.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        service.deletePlayer(id);
        return "Player deleted successfully";
    }

}