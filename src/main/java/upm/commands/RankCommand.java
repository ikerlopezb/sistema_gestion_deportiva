package upm.commands;

import upm.Player;
import upm.PlayerList;
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
        return;
    }
}
