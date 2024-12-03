package upm.controller.commands;

import upm.controller.Controller;

public class TournamentListCommand extends Command{

    private Controller controller;
    public TournamentListCommand(Controller controller) {
        super("tournament-list");
        this.controller = controller;
    }

    public void execute(String[] input) {

    }
}
