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

    public RandomMatchmakeCommand(PlayerList playerList, MatchList matchList){
        super("random_matchmake");
        this.playerList = playerList;
        this.matchList = matchList;
    }
    public void execute(String[] input){
        assert input.length == 1;
        Random random = new Random();
        int playersWithoutMatch = this.playerList.size();

        if(playersWithoutMatch % 2 == 0) {
            while(playersWithoutMatch > 0) {
                int index = random.nextInt(0, playerList.size() - 1);

                playersWithoutMatch--;
            }

        }


    }
}
