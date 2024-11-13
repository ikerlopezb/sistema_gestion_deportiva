package upm.commands;

import upm.Match;
import upm.Player;

import java.util.List;

public class ShowMatchmakeCommand extends Command {


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
    }
}
