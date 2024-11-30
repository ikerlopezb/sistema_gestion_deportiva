package upm.controller.commands;

import upm.Error;
import upm.controller.AdminController;
import upm.view.ErrorView;
import upm.model.Player;
import upm.list.PlayerList;
import upm.model.User;

public class RemoveCommand extends Command {
    private PlayerList playerList;
    private AdminController adminController;
    private ErrorView error;

    public RemoveCommand(AdminController adminController) {
        super("remove");
        this.adminController = adminController;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        String playerName = input[1];
        this.adminController.deletePlayer(playerName);
    }
}
