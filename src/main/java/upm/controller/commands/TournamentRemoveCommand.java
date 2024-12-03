package upm.controller.commands;

import upm.controller.Controller;

public class TournamentRemoveCommand extends Command{

    private Controller controller;
    public TournamentRemoveCommand(Controller controller) {
        super("tournament-remove");
        this.controller = controller;
    }

    public void execute(String[] input) {

    }

}
