package upm.views;

import upm.utils.Controller;

public class TournamentDeleteCommand extends Command {

    private Controller controller;
    public TournamentDeleteCommand(Controller controller) {
        super("tournament-delete");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        this.controller.tournamentDelete(input[1]);
    }


}
