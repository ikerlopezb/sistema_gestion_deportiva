package upm.commands;

import upm.MatchController;
import upm.PlayerController;
import upm.model.Player;
import upm.Match;

public class MatchmakeCommand extends Command {
    MatchController matchController;
    PlayerController playerController;

    public MatchmakeCommand(MatchController matchController, PlayerController playerController) {
        super("matchmake");
        this.playerController = playerController;
        this.matchController = matchController;
    }

    public void execute(String[] input) {
        assert input.length == 3;

        if (!(this.matchController.isPaired(this.playerController.isPlayer(input[1])) &&
                this.matchController.isPaired(this.playerController.isPlayer(input[2])))) {
            Player[] arrayPlayers = new Player[]{this.playerController.isPlayer(input[1]), this.playerController.isPlayer(input[2])};
            Match match = new Match(arrayPlayers);
            this.matchController.add(match);
        }
    }
}
