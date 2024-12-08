package upm.views;

import upm.utils.Controller;

public class CreateCommand extends Command {
    private Controller controller;


    public CreateCommand(Controller controller) {
        super("create");
        this.controller = controller;
    }

    public void execute(String[] input) {

        assert input.length == 6;
        this.controller.createPlayer(input[1], input[2], input[3], input[4], input[5]);
    }

}
