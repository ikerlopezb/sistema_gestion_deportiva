package upm.commands;

import upm.Match;
import upm.MatchList;
import upm.Player;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ShowMatchmakeCommand extends Command {
    MatchList matches;


    public ShowMatchmakeCommand(MatchList matches) {
        super("sho_matchmake");
        this.matches = matches;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        Iterator<Match> iterator = matches.getIterator();
        for(Match match : this.matches.getMatchList()) {
            System.out.print(match.getPlayers()[0].getName() + " vs " + match.getPlayers()[1].getName());
        }
    }
}
