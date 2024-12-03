package upm.list;

import upm.Tournament;
import upm.model.Team;

import java.util.List;

public class TournamentList {
    private List<Tournament> tournamentList;

    public TournamentList (List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }


}
