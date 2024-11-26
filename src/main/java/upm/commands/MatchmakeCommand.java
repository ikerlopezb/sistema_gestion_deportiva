package upm.commands;

import upm.MatchList;
import upm.PlayerList;
import upm.Player;
import upm.Match;

public class MatchmakeCommand extends Command {
    MatchList matchList;
    PlayerList playerList;

    public MatchmakeCommand(MatchList matchList, PlayerList playerList) {
        super("matchmake");
        this.playerList = playerList;
        this.matchList = matchList;
    }

    public void execute(String[] input) {
        assert input.length == 3;

        if (!(this.matchList.isPaired(this.playerList.isPlayer(input[1])) &&
                this.matchList.isPaired(this.playerList.isPlayer(input[2])))) {
            Player[] arrayPlayers = new Player[]{this.playerList.isPlayer(input[1]), this.playerList.isPlayer(input[2])};
            Match match = new Match(arrayPlayers);
            this.matchList.add(match);
        }
    }
}
