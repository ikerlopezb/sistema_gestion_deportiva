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
        return this.matchList;
    }

    /*public ArrayList<Match> getMatches() {
        return this.matches;
    }*/

    public boolean isPaired(Player player) {
        assert this.playerList.contains(player);
        if(!this.matchList.isEmpty()){
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

    public Iterator getIterator() {
        return this.matchList.iterator();
    }
}
