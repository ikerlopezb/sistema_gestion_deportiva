package upm.commands;

import upm.commands.Command;
import upm.Player;
import upm.PlayerList;
import upm.MatchList;
import upm.Match;

import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class RandomMatchmakeCommand extends Command {
    private PlayerList playerList;
    private MatchList matchList;
    private ArrayList<Integer> indexArray = new ArrayList<>();

    public RandomMatchmakeCommand(PlayerList playerList, MatchList matchList){
        super("random_matchmake"); // no funciona el método
        this.playerList = playerList;
        this.matchList = matchList;
    }

    public void execute(String[] input){
        assert input.length == 1;
        matchList.clear();
        int playersWithoutMatch = this.playerList.size();

        if(playersWithoutMatch % 2 == 0) {
            while(playersWithoutMatch > 0){
                //System.out.println(playerListCopy.size());
                this.matchList.add(randomMatchmake());
                playersWithoutMatch -= 2;
            }
        }
    }
/*
    private Player randomPlayer() {
        Random random = new Random();
        int randomIndex = random.nextInt(0, this.playerList.size());
        Iterator<Integer> iterator = indexArray.iterator();
        for(int i = 0; i<this.indexArray.size(); i++){
            if(this.indexArray.get(i))
                this.indexArray.add(randomIndex);
        }

        return this.playerList.getIndex(randomIndex);
    }

 */

    private MatchList randomMatchmake(){
        Match match = null;
        Player[] arrayPlayers = new Player[2];
        Collections.shuffle(this.playerList.getPlayerList());
        for(Player player : this.playerList.getPlayerList()) {

        }
    }
}
