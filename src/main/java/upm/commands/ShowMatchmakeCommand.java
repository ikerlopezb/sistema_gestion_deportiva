package upm.commands;

import upm.Match;
import upm.MatchList;
import upm.Player;

import java.util.List;

public class ShowMatchmakeCommand extends Command {
    MatchList matchmake;


    public ShowMatchmakeCommand(){
        super("show_matchmake");
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
        for (Match matches : this.matchmake.getMatches()){
            for (int i = 0; i <matches.getPlayers().length ; i++) {
                System.out.println(matches.getPlayers()[i].getName());
            }
        }

    }
}
