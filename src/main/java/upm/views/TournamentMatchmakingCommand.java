package upm.views;

import upm.utils.Controller;
import upm.utils.models.Participant;

public class TournamentMatchmakingCommand extends Command {

    private Controller controller;

    public TournamentMatchmakingCommand(Controller controller) {
        super("tournament-matchmaking");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 3 || input.length == 5;
        if (input.length == 3) {
            this.controller.tournamentMatchmakingAutomatic(input[2]);
        } else {
            Participant participant = this.controller.findParticipant(input[3]);
            Participant participant2 = this.controller.findParticipant(input[4]);
            this.controller.tournamentMatchmakingManual(input[2], participant, participant2);
        }
    }
}
