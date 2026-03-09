package com.hexaware.cricket.exception;

import java.util.UUID;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(UUID playerId) {
        super("Player not found with ID: " + playerId);
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
