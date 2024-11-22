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
        /*if (matches.size() == 0) {
            System.out.println("No hay emparejamientos en el sistema.");
        }
        else{
            for (Match match : this.matches.getMatches()) {
                Player[] players = match.getPlayers();
                System.out.println(players[0].getName() + " vs " + players[1].getName());
            }
        }

         */
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
