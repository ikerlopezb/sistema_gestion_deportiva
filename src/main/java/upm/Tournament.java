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
    public void showMatchmake(){ //Deberíamos mostrar también el score?
        Iterator<Player[]> iterator = matches.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next()[0].getName() + " vs " + iterator.next()[1].getName());
        }
    }

    public void randomMatchmake(){
        assert listOfPlayers.size() % 2 == 0;
        clearMatchmake();
        int numPlayers = listOfPlayers.size();
        do{
            matches.add(matchmake());
            numPlayers -= 2;
        }while(numPlayers > 0);
    }

    private int randIndex(){
        Random random = new Random();
        int randInd = random.nextInt(listOfPlayers.size());
        return paired(listOfPlayers.get(randInd)) ? randIndex() : randInd;
    }

    private Player[] matchmake(){
        Player[] players = new Player[2];
        for (int i = 0; i < players.length; i++) {
            players[i] = listOfPlayers.get(randIndex());
        }
        return players;
    }
}
