package upm.controller.commands;

import upm.controller.Controller;

public class TeamRemoveCommand extends Command{
    private Controller controller;

    public TeamRemoveCommand(Controller controller) {
        super("team-remove");
        this.controller = controller;
    }
    public void execute(String[] input) {
        assert input.length == 3;
        this.controller.teamRemove(input[1], input[2]);
    }
}
