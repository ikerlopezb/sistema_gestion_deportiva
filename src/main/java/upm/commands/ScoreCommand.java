package upm.commands;

import upm.PlayerList;
import upm.commands.Command;

public class ScoreCommand extends Command {
    PlayerList playerList;
    public ScoreCommand(PlayerList playerList){
        super("score");
        this.playerList = playerList;
    }
    public void execute(String[] input){
        return;
    }
}
