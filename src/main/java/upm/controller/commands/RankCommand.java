package upm.controller.commands;

import upm.model.Player;
import upm.list.PlayerList;
import java.util.ArrayList;

import java.util.Comparator;

public class RankCommand extends Command {
    private PlayerList playerList;

    public RankCommand(PlayerList playerList){
        super("rank");
        this.playerList = playerList;
    }
    public void execute(String[] input){
        ArrayList<Player> sortedPlayers = new ArrayList<>(playerList.getPlayerList());
        sortedPlayers.sort(Comparator.comparingDouble(Player::getScore).reversed());
        for (Player player : sortedPlayers) {
            System.out.println("Name: " + player.getName() + ", Score: " + player.getScore());
        }
    }
}
