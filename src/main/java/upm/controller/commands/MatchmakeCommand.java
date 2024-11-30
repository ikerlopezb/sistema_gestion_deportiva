package upm.controller.commands;

import upm.controller.MatchController;
import upm.controller.PlayerController;
import upm.model.Player;
import upm.Match;
import upm.Error;
import upm.model.User;
import java.util.List;
import upm.view.ErrorView;


public class MatchmakeCommand extends Command {
    private MatchController matchController;
    private PlayerController playerController;
    private ErrorView error;

    public MatchmakeCommand(MatchController matchController, PlayerController playerController) {
        super("matchmake");
        this.playerController = playerController;
        this.matchController = matchController;
    }

    public void execute(String[] input, User user) {
        assert input.length == 3;

        if (!(this.matchController.isPaired(this.playerController.isPlayer(input[1])) &&
                this.matchController.isPaired(this.playerController.isPlayer(input[2])))) {

            Player[] arrayPlayers = new Player[]{this.playerController.isPlayer(input[1]), this.playerController.isPlayer(input[2])};
            Match match = new Match(arrayPlayers);
            this.matchController.addMatch(match);
        }
        else{
            error.writeln(Error.PLAYER_ALREADY_MATCHED);
        }
    }
}
