package upm;

import upm.list.MatchList;
import upm.list.TeamList;
import upm.model.Match;
import upm.model.Participant;

import java.util.Collections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import upm.model.Player;
import upm.model.Team;
import upm.view.ErrorView;


public class Tournament {
    private String tournamentName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Category category;
    private ArrayList<Participant> participants;
    private MatchList matchList;
    private ErrorView error;


    public Tournament(String tournamentName, LocalDate startDate, LocalDate endDate, Category rankingCategory) {
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = rankingCategory;
        this.participants = new ArrayList<>();
        this.matchList = new MatchList();
    }

    public Category getCategory() {
        return category;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public String getTournamentName() {
        return tournamentName;
    }
    public boolean currentlyCompeting(Participant participant) {
        boolean competing = false;
        Iterator<Participant> iterator = participants.iterator();
        Participant participantIterator = iterator.next();

        while (!(participantIterator.getKey().equals(participant.getKey())) && iterator.hasNext()) {
            participantIterator = iterator.next();
        }
        if (participantIterator.getKey().equals(participant.getKey())) {
            LocalDate actual = LocalDate.now();
            competing = startDate.isBefore(actual) || startDate.isEqual(actual);
        }
        return competing;
    }


    public void remove(Participant participant) {
        this.remove(participant);
    }

    public void showShuffleParticipants() {
        this.shuffle();
        for(Participant participant : this.participants) {
            System.out.println(participant.getKey());
        }
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    private void shuffle() {
        Collections.shuffle(participants);
    }

    public void showRankingParticipants() {
        for(Participant participant : this.participants) {
            System.out.println(participant.getKey() + participant.getRank(this.category));
        }
    }
    public void remove(Player player, TeamList teamList){
        if(player.isInTeam()){
           Team team = teamList.whichTeam(player);
           this.remove(team);
        }
        else {
            this.remove(player);
        }
    }


    public void tournamentMatchmaking(Participant participant1, Participant participant2) {
        this.matchamke(participant1, participant2);
    }

    public void matchamke(Participant participant, Participant participant2){
        if (!(this.matchList.isPaired(participant) &&
                this.matchList.isPaired(participant2))){

            Player[] arrayPlayers = new Player[]{this.playerList.isPlayer(input[1]), this.playerList.isPlayer(input[2])};
            Match match = new Match(arrayPlayers);
            this.matchList.addMatch(match);
        }
        else{
            error.writeln(Error.PLAYER_ALREADY_MATCHED);
        }
    }

    public void randomMatchmake(){

    }



}

