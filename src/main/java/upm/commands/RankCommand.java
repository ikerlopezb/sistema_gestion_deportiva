package upm.commands;

import upm.Player;
import upm.PlayerList;
import java.util.ArrayList;
import upm.commands.Command;

import java.util.Collections;
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
    }
}
