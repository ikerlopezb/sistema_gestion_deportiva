package upm.views;

import upm.utils.Controller;

public class PlayerDeleteCommand extends Command {
    private Controller controller;

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
