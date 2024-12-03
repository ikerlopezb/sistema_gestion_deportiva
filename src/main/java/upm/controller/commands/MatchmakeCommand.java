package upm.controller.commands;

import upm.list.MatchList;
import upm.list.PlayerList;
import upm.model.Player;
import upm.model.Match;
import upm.Error;
import upm.model.User;
import upm.view.ErrorView;
import upm.controller.Controller;


public class MatchmakeCommand extends Command {
    private ErrorView error;
    private Controller controller;

    public MatchmakeCommand(Controller controller) {
        super("matchmake");
        this.controller = controller;
    }

    public void execute(String[] input, User user) {
        assert input.length == 3;

        if (!(this.matchList.isPaired(this.playerList.isPlayer(input[1])) &&
                this.matchList.isPaired(this.playerList.isPlayer(input[2])))) {

            Player[] arrayPlayers = new Player[]{this.playerList.isPlayer(input[1]), this.playerList.isPlayer(input[2])};
            Match match = new Match(arrayPlayers);
            this.matchList.addMatch(match);
        }
        else{
            error.writeln(Error.PLAYER_ALREADY_MATCHED);
        }
    }
}
