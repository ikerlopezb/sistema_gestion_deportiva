package upm.list;

import upm.Tournament;
import upm.model.Participant;
import upm.model.Player;
import upm.model.Team;

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

    public Tournament getTournamentParticipant(Participant participant){
        return iterateTournamentList(participant);
    }
    private Tournament iterateTournamentList(Participant participant){
        Iterator<Tournament> iterator = this.tournamentList.iterator();
        Tournament tournament = iterator.next();
        while(tournament.currentlyCompeting(participant) && iterator.hasNext()) {
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
