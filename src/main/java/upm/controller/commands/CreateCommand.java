package upm.controller.commands;

import upm.controller.Controller;

public class CreateCommand extends Command {
    private Controller controller;


    public CreateCommand(Controller controller) {
        super("create");
        this.controller = controller;
    }

    public void execute(String[] input) {

        assert input.length == 2;
        String playerName = input[1];
        this.controller.createPlayer(playerName);
    }

}
