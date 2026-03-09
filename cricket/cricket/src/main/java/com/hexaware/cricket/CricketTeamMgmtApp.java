package com.hexaware.cricket;

import com.hexaware.cricket.dto.PlayerRequest;
import com.hexaware.cricket.dto.PlayerResponse;
import com.hexaware.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class CricketTeamMgmtApp implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;

    public static void main(String[] args) {
        SpringApplication.run(CricketTeamMgmtApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Cricket Player Management =====");
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Update Player");
            System.out.println("4. Delete Player");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    PlayerRequest req = new PlayerRequest();

                    System.out.print("Player Name: ");
                    req.setPlayerName(sc.nextLine());

                    System.out.print("Jersey Number: ");
                    req.setJerseyNumber(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Role: ");
                    req.setRole(sc.nextLine());

                    System.out.print("Total Matches: ");
                    req.setTotalMatches(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Team Name: ");
                    req.setTeamName(sc.nextLine());

                    System.out.print("Country/State: ");
                    req.setCountryState(sc.nextLine());

                    System.out.print("Description: ");
                    req.setDescription(sc.nextLine());

                    PlayerResponse saved = playerService.createPlayer(req);
                    System.out.println("Player Added: " + saved);

                    break;

                case 2:

                    List<PlayerResponse> players = playerService.getAllPlayers();

                    players.forEach(System.out::println);

                    break;

                case 3:

                    System.out.print("Enter Player ID to update: ");
                    UUID updateId = UUID.fromString(sc.nextLine());

                    PlayerRequest updateReq = new PlayerRequest();

                    System.out.print("Player Name: ");
                    updateReq.setPlayerName(sc.nextLine());

                    System.out.print("Jersey Number: ");
                    updateReq.setJerseyNumber(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Role: ");
                    updateReq.setRole(sc.nextLine());

                    System.out.print("Total Matches: ");
                    updateReq.setTotalMatches(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Team Name: ");
                    updateReq.setTeamName(sc.nextLine());

                    System.out.print("Country/State: ");
                    updateReq.setCountryState(sc.nextLine());

                    System.out.print("Description: ");
                    updateReq.setDescription(sc.nextLine());

                    PlayerResponse updated = playerService.updatePlayer(updateId, updateReq);

                    System.out.println("Player Updated: " + updated);

                    break;

                case 4:

                    System.out.print("Enter Player ID to delete: ");
                    UUID deleteId = UUID.fromString(sc.nextLine());

                    playerService.deletePlayer(deleteId);

                    System.out.println("Player Deleted");

                    break;

                case 5:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid choice");

            }

        }

    }
}