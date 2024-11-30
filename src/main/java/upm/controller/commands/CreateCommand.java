package upm.controller.commands;

import upm.Error;
import upm.model.Player;
import upm.controller.PlayerController;
import upm.model.User;
import upm.view.ErrorView;

import java.util.List;

public class CreateCommand extends Command {

    private PlayerController playerController;
    private ErrorView error;

    public CreateCommand(PlayerController playerController) {
        super("create");
        this.playerController = playerController;
    }

    public void execute(String[] input, User user) {

        assert input.length == 2;
        String playerName = input[1];
        if (this.playerController.isPlayer(playerName) == null) {
            Player player = new Player(playerName);
            playerController.addPlayer(player);
        } else {
            error.writeln(Error.PLAYER_ALREADY_EXISTS);
        }
    }

}
