package upm.utils;

import upm.utils.models.Match;
import upm.utils.models.Participant;

import java.util.ArrayList;
import java.util.Iterator;
public class MatchList {
    private ArrayList<Match> matchList; //como atributo lista de matches

    public MatchList() {
        this.matchList = new ArrayList<Match>();
    }
    public ArrayList<Match> getMatchList() {
        return this.matchList;
    }

    public boolean isPaired(Participant participant) {
        //assert this.playerList.containsPlayer(player);
        if(!this.matchList.isEmpty()){
            int i = 0;
            Participant[] arrayParticipants = this.matchList.get(i).getParticipants();

            while (i < this.matchList.size() && !(arrayParticipants[0].equals(participant) ||
                    arrayParticipants[1].equals(participant))) {
                i++;
                arrayParticipants = this.matchList.get(i).getParticipants();
            }
            return arrayParticipants[0].equals(participant) || arrayParticipants[1].equals(participant);
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
