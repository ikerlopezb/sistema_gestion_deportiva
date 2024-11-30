package upm.controller.commands;

import upm.model.Player;
import upm.controller.PlayerController;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class RankCommand extends Command {
    private PlayerController playerController;

    public RankCommand(PlayerController playerController){
        super("rank");
        this.playerController = playerController;
    }
    public void execute(String[] input){
        ArrayList<Player> sortedPlayers = new ArrayList<>(playerController.getPlayerList());
        sortedPlayers.sort(Comparator.comparingDouble(Player::getScore).reversed());
        for (Player player : sortedPlayers) {
            System.out.println("Name: " + player.getName() + ", Score: " + player.getScore());
        }
    }
}
