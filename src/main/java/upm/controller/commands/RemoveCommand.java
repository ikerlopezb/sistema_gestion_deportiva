package upm.controller.commands;

import upm.Error;
import upm.view.ErrorView;
import upm.model.Player;
import upm.controller.PlayerController;
import upm.model.User;
import java.util.List;

public class RemoveCommand extends Command {
    private PlayerController playerController;
    private ErrorView error;

    public RemoveCommand(PlayerController playerlist) {
        super("remove");
        this.playerController = playerlist;
    }

    public void execute(String[] input, User user) {
        assert input.length == 2;
        Player player = this.playerController.isPlayer(input[1]);
        if(player != null) {
            this.playerController.removePlayer(player);
        } else {
            error.writeln(Error.PLAYER_NOT_FOUND);
        }
    }
}
