package upm.controller;

import upm.Match;
import upm.model.Player;

import java.util.ArrayList;
import java.util.Iterator;
public class MatchController {


    private ArrayList<Match> matchList; //como atributo lista de matches
    private PlayerController playerController;

    public MatchController(PlayerController playerController) {
        this.playerController = playerController;
        this.matchList = new ArrayList<Match>();
    }
    public ArrayList<Match> getMatchList() {
        return this.matchList;
    }

    public boolean isPaired(Player player) {
        assert this.playerController.containsPlayer(player);
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


    public void clearmatchList(){
        this.matchList.clear();
    }

    public void addMatch(Match match){
        this.matchList.add(match);
    }

    public int size() { return this.matchList.size(); }

    public Iterator getIterator() {
        return this.matchList.iterator();
    }
}
