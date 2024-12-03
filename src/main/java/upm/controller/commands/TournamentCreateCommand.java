package upm.controller.commands;

import upm.controller.Controller;

public class TournamentCreateCommand extends Command{

    private Controller controller;

    public TournamentCreateCommand(Controller controller) {
        super("tournament-create");
        this.controller = controller;
    }

    public void execute(String[] input) {

    }

}
