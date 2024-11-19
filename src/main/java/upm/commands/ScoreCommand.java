package upm.commands;

import upm.Player;
import upm.PlayerList;
import upm.commands.Command;

public class ScoreCommand extends Command {
    PlayerList playerList;
    public ScoreCommand(PlayerList playerList){
        super("score");
        this.playerList = playerList;
    }
    public void execute(String[] input){
        assert input.length == 3;
        Player player = playerList.isPlayer(input[1]);
        if(playerList.contains(player)) {
            player.setScore(Double.parseDouble(input[2]));
        }
    }
}
