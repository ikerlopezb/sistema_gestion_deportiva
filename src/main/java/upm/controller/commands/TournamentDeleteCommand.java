package upm.controller.commands;

import upm.controller.Controller;

import java.util.Arrays;

public class TournamentDeleteCommand extends Command{

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
