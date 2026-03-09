package com.hexaware.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket.service.IPlayerService;
import com.hexaware.cricketi.dto.PlayerDTO;


@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private IPlayerService service;
    
    
    @PostMapping("/add")
    public PlayerDTO createPlayer(@RequestBody PlayerDTO dto){
        return service.createPlayer(dto);
    }


    @GetMapping("/getall")
    public List<PlayerDTO> getPlayers(){
        return service.getAllPlayers();
    }

   
    @GetMapping("/get/{playerId}")
    public PlayerDTO getPlayer(@PathVariable int playerId){
        return service.getPlayerById(playerId);
    }

    @PutMapping("/update/{playerId}")
    public PlayerDTO updatePlayer(@PathVariable int playerId, @RequestBody PlayerDTO dto){
        return service.updatePlayer(playerId, dto);
    }

    @DeleteMapping("/delete/{playerId}")
    public String deletePlayer(@PathVariable int playerId){
        service.deletePlayer(playerId);
        return "Player deleted successfully";
    }
}