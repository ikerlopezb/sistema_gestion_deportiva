package upm.controller.commands;

import upm.controller.AdminController;
import upm.controller.PlayerController;

public class CreateCommand extends Command {
    private AdminController adminController;


    public CreateCommand(AdminController adminController) {
        super("create");
        this.adminController = adminController;
    }

    public void execute(String[] input) {

        assert input.length == 2;
        String playerName = input[1];
        this.adminController.createPlayer(playerName);
    }

}
