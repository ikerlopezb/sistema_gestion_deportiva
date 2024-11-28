package upm.controller.commands;

import upm.Error;
import upm.model.Player;
import upm.controller.PlayerController;
import upm.model.User;

import java.util.List;

public class RemoveCommand extends Command {
    private PlayerController playerController;

    public RemoveCommand(PlayerController playerlist) {
        super("remove", List.of("Player"));
        this.playerController = playerlist;
    }

    public Error execute(String[] input, User user) {
        assert input.length == 2;
        Player player = this.playerController.isPlayer(input[1]);
        if(player != null) {
            this.playerController.removePlayer(player);
            return Error.NONE;
        } else {
            return Error.PLAYER_NOT_FOUND;
        }
    }
}