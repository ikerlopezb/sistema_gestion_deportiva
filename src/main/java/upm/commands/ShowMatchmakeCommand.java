package upm.commands;

import upm.Match;
import upm.MatchList;
import upm.Player;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ShowMatchmakeCommand extends Command {
    MatchList matches;


    public ShowMatchmakeCommand(MatchList matches){
        super("show_matchmake");
        this.matches = matches;
    }
    public void execute(String[] input){
        assert input.length == 1;
        /*if (matches.isEmpty()) {
            System.out.println("No hay emparejamientos en el sistema.");
        }
        for (Match match : matches) {
            Player[] players = match.getPlayers();
            System.out.println(players[0].getName() + " vs " + players[1].getName());
        }
         */

        Iterator<Match> iterator = matches.getiterator();
        while(iterator.hasNext()) {
            Match match = iterator.next();
            for (int i = 0; i < match.length(); i++) {
                System.out.println(match.getPlayers()[i]);
            }
        }



    }
}
