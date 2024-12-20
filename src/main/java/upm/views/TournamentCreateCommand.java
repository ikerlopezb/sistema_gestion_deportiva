package upm.views;

import upm.utils.Controller;

public class TournamentCreateCommand extends Command {

    private Controller controller;

    public TournamentCreateCommand(Controller controller) {
        super("tournament-create");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 5;
        this.controller.tournamentCreate(input[1], input[2], input[3], input[4]);
    }

}
