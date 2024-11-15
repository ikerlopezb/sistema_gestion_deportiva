package upm.commands;

import upm.commands.Command;
import upm.MatchList;
import upm.PlayerList;
import upm.Player;
import upm.Match;

public class MatchmakeCommand extends Command {
    MatchList matchmake;
    PlayerList playerList;

    public MatchmakeCommand(){
        super("matchmake");
    }
    public void execute(String[] input){
        assert input.length == 3;

        if(matchmake.getMatches().isPaired(playerList.isPlayer(input[1]))) {

        }

    }
}
