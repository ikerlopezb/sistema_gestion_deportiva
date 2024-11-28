package upm.controller.commands;

import upm.model.Player;
import upm.controller.PlayerController;
import upm.model.User;

import java.util.List;

public class CreateCommand extends Command {

    private PlayerController playerController;

    public CreateCommand(PlayerController playerController) {
        super("create", List.of("Admin"));
        this.playerController = playerController;
    }

    public void execute(String[] input, User user) {

        assert input.length == 2;
        String playerName = input[1];
        if (this.playerController.isPlayer(playerName) == null) {
            Player player = new Player(playerName);
            playerController.addPlayer(player);
            return Error.NONE;
        } else {
            return Error.PLAYER_ALREADY_EXISTS;
        }
    }

}
