package upm.views;

import upm.utils.Controller;
import upm.utils.PlayerList;

public class PlayerDeleteCommand extends Command {
    private PlayerList playerList;
    private Controller controller;
    private ErrorView error;

    public PlayerDeleteCommand(Controller controller) {
        super("remove");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        String playerName = input[1];
        this.controller.deletePlayer(playerName);
    }
}
