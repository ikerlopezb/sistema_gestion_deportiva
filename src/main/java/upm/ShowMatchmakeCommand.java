package upm;

import java.util.List;

public class ShowMatchmakeCommand {
    //private List<Match> matches;

    public ShowMatchmakeCommand(List<Match> matches){
        super("show_matchmake");
        this.matches = matches;
    }
    public void execute(String[] input){
        assert isYours(input[0]);
        if (matches.isEmpty()) {
            System.out.println("No hay emparejamientos en el sistema.");
        }
        for (Match match : matches) {
            Player[] players = match.getPlayers();
            System.out.println(players[0].getName() + " vs " + players[1].getName());
        }
    }
}
