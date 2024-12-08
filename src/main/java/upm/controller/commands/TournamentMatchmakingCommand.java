package upm.controller.commands;

import upm.controller.Controller;
import upm.model.Participant;

public class TournamentMatchmakingCommand extends Command{

    private Controller controller;
    public TournamentMatchmakingCommand(Controller controller) {
        super("tournament-matchmaking");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 3;
        Participant participant = null;
        participant.isParticipant(input[1]);
        controller.tournamentMatchmaking();
    }
}
