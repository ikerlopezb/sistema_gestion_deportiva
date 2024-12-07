package upm;

import upm.model.Participant;

import java.util.Collections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

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
    public boolean isCompeting(Team team) {
        boolean competing = false;

        Iterator<Participant> iterator = participants.iterator();
        Participant participant = iterator.next();

        while (!(participant.getName().equals(team.getName())) && iterator.hasNext()) {
            participant = iterator.next();
        }
        if (participant.getName().equals(team.getName())) {
            LocalDate actual = LocalDate.now(); // Obtener la fecha actual
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
            System.out.println(participant.getName());
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
            System.out.println(participant.getName() + participant.getRank(this.category));
        }
    }



}

