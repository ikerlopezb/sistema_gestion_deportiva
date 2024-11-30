package upm.controller.commands;

import upm.model.Player;
import upm.list.PlayerList;
import upm.view.ErrorView;
import upm.Error;

public class ScoreCommand extends Command {
    private PlayerList playerList;
    private ErrorView error;
    public ScoreCommand(PlayerList playerList){
        super("score");
        this.playerList = playerList;
    }
    public void execute(String[] input){
        assert input.length == 3;
        Player player = playerList.isPlayer(input[1]);
        if(playerList.containsPlayer(player)) {
            player.setScore(Double.parseDouble(input[2]));
        }
        else{
            error.writeln(Error.PLAYER_NOT_FOUND);
        }
    }
}
