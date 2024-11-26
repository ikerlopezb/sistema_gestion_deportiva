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
    private PlayerList playerListCopy;

    public RandomMatchmakeCommand(PlayerList playerList, MatchList matchList){
        super("random_matchmake"); // no funciona el método
        this.playerList = playerList;
        this.matchList = matchList;
        this.playerListCopy = playerList
    }
    public void execute(String[] input){
        assert input.length == 1;
        matchList.clear();
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
        /*int randomIndex = random.nextInt(0, this.playerList.size());
        return this.playerList.getIndex(randomIndex);*/
        int randomIndex = random.nextInt(0, this.playerListCopy.size());
        return this.playerListCopy.getIndex(randomIndex);
    }

    private Match randomMatchmake(){
        Match match = null;
        Player[] arrayPlayers = new Player[2];
        Player player = null;
        int i = 0;
        while(i < 2) {
            player = randomPlayer();
            if ((!arrayPlayers[0].equals(player) && !this.matchList.isPaired(player))){
                arrayPlayers[i] = player;
                i++;
            }
        }
        match = new Match(arrayPlayers);
        return match;
    }

    public PlayerList getPlayerListCopy() {
        return playerListCopy;
    }

    public void setPlayerListCopy(PlayerList playerListCopy) {
        this.playerListCopy = playerListCopy;
    }
}
