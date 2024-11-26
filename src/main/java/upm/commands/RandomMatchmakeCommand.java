package upm.commands;


import upm.Player;
import upm.PlayerList;
import upm.MatchList;
import upm.Match;
import java.util.Collections;

public class RandomMatchmakeCommand extends Command {
    private PlayerList playerList;
    private MatchList matchList;

    public RandomMatchmakeCommand(PlayerList playerList, MatchList matchList) {
        super("random_matchmake");
        this.playerList = playerList;
        this.matchList = matchList;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        this.matchList.clear();
        int playersWithoutMatch = this.playerList.size();

        if (playersWithoutMatch % 2 == 0) {
            randomMatchmake();
        }
    }

    private void randomMatchmake() {
        Player[] arrayPlayers;
        int i;
        Collections.shuffle(this.playerList.getPlayerList());
        for (i = 0; i < this.playerList.size(); i += 2) {
            arrayPlayers = new Player[2];
            arrayPlayers[0] = this.playerList.getIndex(i);
            arrayPlayers[1] = this.playerList.getIndex(i + 1);
            Match match = new Match(arrayPlayers);
            this.matchList.add(match);
        }
    }
}
