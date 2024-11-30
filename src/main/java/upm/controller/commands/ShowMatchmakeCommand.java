package upm.controller.commands;

import upm.Match;
import upm.controller.MatchController;
import upm.model.User;

public class ShowMatchmakeCommand extends Command {
    MatchController matchController;


    public ShowMatchmakeCommand(MatchController matchController) {
        super("sho_matchmake");
        this.matchController = matchController;
    }

    public void execute(String[] input, User user) {
        assert input.length == 1;
        for(Match match : this.matchController.getMatchList()) {
            System.out.println(match.getPlayers()[0].getName() + " vs " + match.getPlayers()[1].getName());
        }
    }
}
