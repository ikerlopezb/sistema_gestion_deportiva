package upm.commands;

import upm.commands.Command;
import upm.Player;
import upm.PlayerList;
import upm.MatchList;
import upm.Match;
import java.util.Random;
import java.util.ArrayList;
public class RandomMatchmakeCommand extends Command {
    private PlayerList playerList;
    private MatchList matchList;

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
                Player[] match = new Player[2];
                int i = 0;
                while(match.length < 2) {
                    int randomIndex = random.nextInt(0, playerList.size() - 1);
                    Player player = this.playerList.getIndex(randomIndex);
                    if(this.)
                    playersWithoutMatch--;
                }
            }

        }


    }
}
