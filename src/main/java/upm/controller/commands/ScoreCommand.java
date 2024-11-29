package upm.controller.commands;

import upm.model.Player;
import upm.controller.PlayerController;
import upm.view.ErrorView;
import upm.Error;

public class ScoreCommand extends Command {
    private PlayerController playerController;
    private ErrorView error;
    public ScoreCommand(PlayerController playerController){
        super("score");
        this.playerController = playerController;
    }
    public void execute(String[] input){
        assert input.length == 3;
        Player player = playerController.isPlayer(input[1]);
        if(playerController.containsPlayer(player)) {
            player.setScore(Double.parseDouble(input[2]));
        }
        else{
            error.writeln(Error.PLAYER_NOT_FOUND);
        }
    }
}
