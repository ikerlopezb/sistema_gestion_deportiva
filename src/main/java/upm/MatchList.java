package upm;

import upm.commands.Command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MatchList {
    private ArrayList<Match> matches; //como atributo lista de matches
    private PlayerList playerList;

    public MatchList(PlayerList playerList) {
        this.playerList = playerList;
        this.matches = new ArrayList<Match>();
    }

    /*public ArrayList<Match> getMatches() {
        return this.matches;
    }*/

    public boolean isPaired(Player player) {//Iker: cambio de private a public y cambio de nombre del método de paired a isPaired
        assert this.playerList.contains(player); //Iker: compruebo si el jugador que me pasan existe
        int i = 0;
        Player[] matchmake = this.matches.get(i).getPlayers();
        while (i < this.matches.size() && !(matchmake[0].equals(player) || matchmake[1].equals(player))) {
            i++;
            matchmake = this.matches.get(i).getPlayers();
        }
        return matchmake[0].equals(player) || matchmake[1].equals(player);
    }

    public void imprimir() {
        for (Match match : this.matches) {
            System.out.println(match.getPlayers()[0].getName());
            System.out.println(match.getPlayers()[1].getName());
        }
    }

    public void clear(){
        this.matches.clear();
    }

    public void add(Match match){
        this.matches.add(match);
    }

    public int size() { return this.matches.size(); }

    public Iterator getiterator() {
        return this.matches.iterator();
    }

    /*Command command = commandList.get(i);
            while (i < commandList.size() && !command.isYours(commandName)) {
        i++;
        command = commandList.get(i);
    }*/



    /*public void matchmake(Player player1, Player player2){
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
    */
}
