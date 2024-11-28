package upm.controller.commands;


import upm.model.Player;
import upm.controller.PlayerController;
import upm.controller.MatchController;
import upm.Match;
import java.util.Collections;

public class RandomMatchmakeCommand extends Command {
    private PlayerController playerController;
    private MatchController matchController;

    public RandomMatchmakeCommand(PlayerController playerController, MatchController matchController) {
        super("random_matchmake");
        this.playerController = playerController;
        this.matchController = matchController;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        this.matchController.clearmatchList();
        int playersWithoutMatch = this.playerController.size();

        if (playersWithoutMatch % 2 == 0) {
            randomMatchmake();
        }
    }

    private void randomMatchmake() {
        Player[] arrayPlayers;
        int i;
        Collections.shuffle(this.playerController.getPlayerList());
        for (i = 0; i < this.playerController.size(); i += 2) {
            arrayPlayers = new Player[2];
            arrayPlayers[0] = this.playerController.getIndex(i);
            arrayPlayers[1] = this.playerController.getIndex(i + 1);
            Match match = new Match(arrayPlayers);
            this.matchController.addMatch(match);
        }
    }
}
