package upm.controller.commands;

import upm.controller.Controller;

public class TeamAddCommand extends Command{
    private Controller controller;

    public TeamAddCommand(Controller controller) {
        super("team-add");
        this.controller = controller;
    }
    public void execute(String[] input) {
        assert input.length == 3;
        this.controller.teamAdd(input[1], input[2]);
    }
}
