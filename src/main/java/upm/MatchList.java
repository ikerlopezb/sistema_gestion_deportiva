package upm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MatchList {
    private ArrayList<Match> matches; //como atributo lista de matches
    private PlayerList playerList;

    public MatchList(PlayerList playerList){
        this.playerList = playerList;
        this.matches = new ArrayList<Match>();
    }
    private boolean paired(Player player){
        Iterator<Match> iterator = matches.iterator();
        while(iterator.hasNext()){
            Match match = iterator.next();
            if(player.equals(match.getPlayers()[0]) || player.equals(match.getPlayers()[1])){
                return true;
            }
        }
        return false;
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
