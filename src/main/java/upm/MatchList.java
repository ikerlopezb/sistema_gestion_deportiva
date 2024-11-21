package upm;

import java.util.ArrayList;
import java.util.Iterator;

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

    public boolean isPaired(Player player) {//Iker: cambio de private a public y cambio de nombre del método de paired a isPaired
        assert this.playerList.contains(player); //Iker: compruebo si el jugador que me pasan existe
        if(!matchList.isEmpty() /*&& notInMatchmake(matchmake, player)*/){
            int i = 0;
            Player[] matchmake = this.matchList.get(i).getPlayers();
            while (i < this.matchList.size() && !(matchmake[0].equals(player) || matchmake[1].equals(player))) {
                i++;
                matchmake = this.matchList.get(i).getPlayers();
            }
            return matchmake[0].equals(player) || matchmake[1].equals(player);
        }
        else{
            return false;
        }

    }
    /*
    private boolean notInMatchmake(Match match, Player player){
        comprueba si el jugador está emparejado él solo a la espera de otro compañero.
        La función de este método es que no empareje dos veces el mismo jugador cuando haces
        un random_matchmake
    }
    */

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
