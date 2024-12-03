package upm.controller.commands;

import upm.controller.Controller;

public class TeamRemoveCommand extends Command{
    private Controller controller;

    public TeamRemoveCommand(Controller controller) {
        super("team-remove");
        this.controller = controller;
    }
    public void execute(String[] input) {

    }
}
