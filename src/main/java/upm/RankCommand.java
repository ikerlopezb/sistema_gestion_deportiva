package upm;

import java.util.Collections;
import java.util.Comparator;

public class RankCommand extends Command {

    public RankCommand(){
        super("rank");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
        Collections.sort(listOfPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return Double.compare(player2.getScore(), player1.getScore());
            }
        });
        for (Player player : listOfPlayers) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}
