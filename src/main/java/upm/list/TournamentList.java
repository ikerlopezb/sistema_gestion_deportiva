package upm.list;

import upm.Tournament;
import upm.model.Team;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class TournamentList {
    private List<Tournament> tournamentList;

    public TournamentList (List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public boolean isCompeting(Team team) {
        Tournament tournament = iterateTournamentList(team);
        return tournament == null;
    }

    public Tournament getTournamentTeam(Team team){
        return iterateTournamentList(team);
    }
    private Tournament iterateTournamentList(Team team){
        Iterator<Tournament> iterator = this.tournamentList.iterator();
        Tournament tournament = iterator.next();
        while(tournament.isCompeting(team) && iterator.hasNext()) {
            tournament = iterator.next();
        }
        return tournament;
    }

    private Tournament iterateTournamentList(String tournamentName){
        Iterator<Tournament> iterator = this.tournamentList.iterator();
        Tournament tournament = iterator.next();
            while(tournament.getTournamentName().equals(tournamentName) && iterator.hasNext()) {
            tournament = iterator.next();
        }
        return tournament;
    }

    public Tournament isTournament(String tournamentName) {
        return iterateTournamentList(tournamentName);
    }
    public void add(Tournament tournament) {
        this.add(tournament);
    }
    public void remove(Tournament tournament){
        this.remove(tournament);
    }
}
