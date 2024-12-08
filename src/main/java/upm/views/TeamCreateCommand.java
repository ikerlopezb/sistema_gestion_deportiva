package upm.views;

import upm.utils.Controller;

public class TeamCreateCommand extends Command {
    private Controller controller;

    public TeamCreateCommand(Controller controller) {
        super("team-create");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        this.controller.teamCreate(input[1]);
    }

}
