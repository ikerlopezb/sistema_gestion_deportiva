package upm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tournament extends ListPlayers {
    private List<Player[]> matches = new ArrayList<>(2);

    private boolean paired(Player player){
        Iterator<Player[]> iterator = matches.iterator();
        while(iterator.hasNext()){
        }
        return matches.contains(player );
    }

    public void matchmake(Player player1, Player player2){
        if((!paired(player1) && exist(player1) )&& (!paired(player2) && exist(player2))){
                matches.add(player1);
                matches.add(player2);
        }
    }

    public void clearMatchmake(){
        matches.clear();
    }
    public void showMatchmake(){
        String name1;
        String name2;
        Iterator<String> iterator = matches.iterator();

        while(iterator.hasNext()){
            name1 = iterator.next();
            if (iterator.hasNext()){
                name2 = iterator.next();
                System.out.println(name1 + " vs " + name2);
            }
        }
    }

    public void randomMatchmake(){
        if(this.numPlayers % 2 == 0) {
            int i;
            do {
                i = matchmake();
                matches.add(this.listOfPlayers[i].getName());
            } while (matches.size() < this.numPlayers);
        }

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
