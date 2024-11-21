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
        int playersWithoutMatch = this.playerList.size();

        if(playersWithoutMatch % 2 == 0) {
            while(playersWithoutMatch > 0){
                this.matchList.add(randomMatchmake());
                playersWithoutMatch -= 2;

            }
        }
    }

    private Player randomPlayer() {
        Random random = new Random();
        int randomIndex = random.nextInt(0, this.playerList.size());
        return this.playerList.getIndex(randomIndex);
    }

    private Match randomMatchmake(){
        Match match = null;
        Player[] matchmake = new Player[2];
        Player player = null;
        int i = 0;
        while(i < 2) {
            player = randomPlayer();
            if (!this.matchList.isPaired(player)){
                matchmake[i] = player;
                i++;
            }
        }
        match = new Match(matchmake);
        return match;
    }
}
