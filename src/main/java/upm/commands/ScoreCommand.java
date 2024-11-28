package upm.commands;

import upm.model.Player;
import upm.PlayerController;

public class ScoreCommand extends Command {
    PlayerController playerController;
    public ScoreCommand(PlayerController playerController){
        super("score");
        this.playerController = playerController;
    }
    public void execute(String[] input){
        assert input.length == 3;
        Player player = playerController.isPlayer(input[1]);
        if(playerController.contains(player)) {
            player.setScore(Double.parseDouble(input[2]));
        }
    }
}
