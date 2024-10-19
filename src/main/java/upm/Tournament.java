package upm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tournament extends ListPlayers {
    private List<Player[]> matches = new ArrayList<>(2);

    private boolean paired(Player player){
        Iterator<Player[]> iterator = matches.iterator();
        while(iterator.hasNext() && !(player.equals(iterator.next()[0]) || player.equals(iterator.next()[1]))){
            iterator.next();
        }
        return (player.equals(iterator.next()[0]) || player.equals(iterator.next()[1]));
    }

    public void matchmake(Player player1, Player player2){
        if((!paired(player1) && exist(player1) )&& (!paired(player2) && exist(player2))){
            Player[] matchmake = new Player[]{player1,player2};
                matches.add(matchmake);
        }
    }

    public void clearMatchmake(){
        matches.clear();
    }
    public void showMatchmake(){
        Iterator<Player[]> iterator = matches.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next()[0].getName() + " vs " + iterator.next()[1].getName());
        }
    }

    public void randomMatchmake(){
        assert listOfPlayers.size() % 2 == 0;
        Iterator <Player> iterator = listOfPlayers.iterator();
        Random random = new Random().ints(0,listOfPlayers.size()-1).distinct()
        /**
        if(this.numPlayers % 2 == 0) {
            int i;
            do {
                i = matchmake();
                matches.add(this.listOfPlayers[i].getName());
            } while (matches.size() < this.numPlayers);
        }
         **/

    }

    private int matchmake(){
        Random random = new Random();
        int i = random.nextInt(this.numPlayers);
        if(paired(this.listOfPlayers[i].getName())) {
            return matchmake();
        }
        return i;
    }
}
