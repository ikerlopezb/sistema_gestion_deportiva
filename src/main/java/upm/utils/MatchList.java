package upm.utils;

import upm.utils.models.Match;
import upm.utils.models.Participant;

import java.util.ArrayList;

public class MatchList {
    private ArrayList<Match> matchList; //como atributo lista de matches

    public MatchList() {
        this.matchList = new ArrayList<Match>();
    }

    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public boolean isPaired(Participant participant) {
        if (!this.matchList.isEmpty()) {
            int i = 0;
            Participant[] arrayParticipants = this.matchList.get(i).getParticipants();

            while (i < this.matchList.size() && !(arrayParticipants[0].equals(participant) ||
                    arrayParticipants[1].equals(participant))) {
                i++;
                arrayParticipants = this.matchList.get(i).getParticipants();
            }
            return arrayParticipants[0].equals(participant) || arrayParticipants[1].equals(participant);
        } else {
            return false;
        }
    }

    public void clearmatchList() {
        this.matchList.clear();
    }

    public void addMatch(Match match) {
        this.matchList.add(match);
    }
}
