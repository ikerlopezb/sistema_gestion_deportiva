package upm.commands;

import upm.commands.Command;
import upm.Player;
import upm.PlayerList;
import upm.MatchList;
import upm.Match;
import java.util.Random;

public class RandomMatchmakeCommand extends Command {
    PlayerList playerList;
    MatchList matchList;

    public RandomMatchmakeCommand(){
        super("random_matchmake");
    }
    public void execute(String[] input){
        assert input.length == 1;
        Random random = new Random();
        //random.


    }
}
