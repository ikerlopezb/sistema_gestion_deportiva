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
        super("show_matchmake");
        this.matches = matches;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        Iterator<Match> iterator = matches.getiterator();
        while (iterator.hasNext()) {
            Match match = iterator.next();
            for (int i = 0; i + 1 < match.length(); i++) {
                System.out.print(match.getPlayers()[i].getName() + " vs " + match.getPlayers()[i].getName());
                //compruebo que el siguiente jugador al actual no sea null.
            }
        }
    }
}
