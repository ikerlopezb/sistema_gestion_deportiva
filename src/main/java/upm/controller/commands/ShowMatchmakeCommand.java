package upm.controller.commands;

import upm.model.Match;
import upm.list.MatchList;
import upm.model.User;

public class ShowMatchmakeCommand extends Command {
    MatchList matchList;


    public ShowMatchmakeCommand(MatchList matchList) {
        super("sho_matchmake");
        this.matchList = matchList;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        for(Match match : this.matchList.getMatchList()) {
            System.out.println(match.getPlayers()[0].getName() + " vs " + match.getPlayers()[1].getName());
        }
    }
}
