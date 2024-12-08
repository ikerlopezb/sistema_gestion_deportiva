package upm.views;

import upm.utils.Controller;

public class TournamentAddCommand extends Command {
    private Controller controller;
    public TournamentAddCommand(Controller controller) {
        super("tournament-add");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 3;
        this.controller.tournamentAdd(input[1], input[2]);
    }

}
