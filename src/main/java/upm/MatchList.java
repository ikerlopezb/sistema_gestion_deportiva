package upm;

import java.util.ArrayList;
import java.util.Iterator;
import upm.Match;
public class MatchList {


    private ArrayList<Match> matchList; //como atributo lista de matches
    private PlayerList playerList;

    public MatchList(PlayerList playerList) {
        this.playerList = playerList;
        this.matchList = new ArrayList<Match>();
    }
    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    /*public ArrayList<Match> getMatches() {
        return this.matches;
    }*/

    public boolean isPaired(Player player) {
        assert this.playerList.contains(player);
        if(!matchList.isEmpty()){
            int i = 0;
            Player[] arrayPlayers = this.matchList.get(i).getPlayers();

            while (i < this.matchList.size() && !(arrayPlayers[0].equals(player) || arrayPlayers[1].equals(player))) {
                i++;
                arrayPlayers = this.matchList.get(i).getPlayers();
            }
            return arrayPlayers[0].equals(player) || arrayPlayers[1].equals(player);
        }
        else{
            return false;
        }
    }


    public void imprimir() {
        for (Match match : this.matchList) {
            System.out.println(match.getPlayers()[0].getName());
            System.out.println(match.getPlayers()[1].getName());
        }
    }

    public void clear(){
        this.matchList.clear();
    }

    public void add(Match match){
        this.matchList.add(match);
    }

    public int size() { return this.matchList.size(); }

    public Iterator getiterator() {
        return this.matchList.iterator();
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
