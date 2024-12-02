package upm.controller.commands;

import upm.controller.Controller;
import upm.view.ErrorView;
import upm.list.PlayerList;

public class RemoveCommand extends Command {
    private PlayerList playerList;
    private Controller controller;
    private ErrorView error;

    public RemoveCommand(Controller controller) {
        super("remove");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        String playerName = input[1];
        this.controller.deletePlayer(playerName);
    }
}
