package upm.controller.commands;

import upm.controller.Controller;

public class TournamentDeleteCommand extends Command{

    private Controller controller;
    public TournamentDeleteCommand(Controller controller) {
        super("tournament-delete");
        this.controller = controller;
    }

    public void execute(String[] input) {

    }


}
