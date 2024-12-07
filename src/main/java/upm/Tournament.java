package upm;

import upm.model.Participant;

import java.util.Collections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import upm.model.Player;
import upm.model.Team;



public class Tournament {
    private String tournamentName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Category category;
    private ArrayList<Participant> participants;


    public Tournament(String tournamentName, LocalDate startDate, LocalDate endDate, Category rankingCategory) {
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = rankingCategory;
        this.participants = new ArrayList<>();
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


    public void remove(Team team) {
        this.remove(team);
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
    public boolean isPlayerInTournament(Player player){
        Iterator<Participant> iterator = this.participants.iterator();
        Participant participant = iterator.next();
        Team team = 

        while(!participant && iterator.hasNext()){
            participant = iterator.next();
        }
        return ;
    }



}

