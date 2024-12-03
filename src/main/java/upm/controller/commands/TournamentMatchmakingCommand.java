package upm.controller.commands;

import upm.controller.Controller;

public class TournamentMatchmakingCommand extends Command{

    private Controller controller;
    public TournamentMatchmakingCommand(Controller controller) {
        super("tournament-matchmaking");
        this.controller = controller;
    }

    public void execute(String[] input) {

    }
}
