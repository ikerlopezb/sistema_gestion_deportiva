package upm.views;

import upm.utils.Controller;

public class TeamDeleteCommand extends Command {
    private Controller controller;

    public TeamDeleteCommand(Controller controller) {
        super("team-delete");
        this.controller = controller;
    }
    public void execute(String[] input) {
        assert input.length == 2;
        this.controller.teamDelete(input[1]);
    }
}
