package upm.commands;

import upm.MatchList;
import upm.PlayerList;
import upm.Player;
import upm.Match;

import java.util.ArrayList;

public class MatchmakeCommand extends Command {
    MatchList matchmake;
    PlayerList playerList;

    public MatchmakeCommand(MatchList matchList, PlayerList playerList) {
        super("matchmake"); // no funciona el método
        this.playerList = playerList;
        this.matchmake = matchList;
    }

    public void execute(String[] input) {
        assert input.length == 3;

        if (!(this.matchmake.isPaired(this.playerList.isPlayer(input[1])) &&
                this.matchmake.isPaired(this.playerList.isPlayer(input[2])))) {
            Player[] match = new Player[]{this.playerList.isPlayer(input[1]), this.playerList.isPlayer(input[2])};
            Match matchmake = new Match(match);
            this.matchmake.add(matchmake);
            //Código comprobación
            for (int i = 0; i < match.length; i++) {
                System.out.println(match[i].getName());//Imprime nombre de los dos jugadores.
            }
            System.out.println("Bucle 1 completado");

            /*for (Match ignored : this.matchmake.getMatches()){
                System.out.println(ignored.getPlayers()[0].getName());
                System.out.println(ignored.getPlayers()[1].getName());
            }*/
        }
    }
}
