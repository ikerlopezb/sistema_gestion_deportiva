package upm.utils;

import upm.utils.models.Match;
import upm.utils.models.Participant;

import java.util.Collections;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import upm.utils.models.Player;
import upm.utils.models.Team;
import upm.views.ErrorView;


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
        for (Participant participant : this.participants) {
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
        for (Participant participant : this.participants) {
            System.out.println(participant.getKey() + participant.getRank(this.category));
        }
    }

    public void remove(Player player, TeamList teamList) {
        if (player.isInTeam()) {
            Team team = teamList.whichTeam(player);
            this.remove(team);
        } else {
            this.remove(player);
        }
    }

    public void matchmake(Participant participant, Participant participant2) {
        if (!(this.matchList.isPaired(participant) &&
                this.matchList.isPaired(participant2))) {

            Participant[] arrayParticipant = new Participant[]{participant, participant2};
            Match match = new Match(arrayParticipant);
            this.matchList.addMatch(match);
        } else {
            error.writeln(Error.PLAYER_ALREADY_MATCHED);
        }
    }

    public boolean areBothCompeting(Participant participant1, Participant participant2) {
        return this.currentlyCompeting(participant1) && this.currentlyCompeting(participant2);
    }


    public void randomMatchmake() {
        this.participants.clear();
        Participant[] arrayParticipants;
        int i;
        Collections.shuffle(this.participants);
        for (i = 0; i < this.participants.size(); i += 2) {
            arrayParticipants = new Participant[2];
            arrayParticipants[0] = this.participants.get(i);
            arrayParticipants[1] = this.participants.get(i + 1);
            Match match = new Match(arrayParticipants);
            this.matchList.addMatch(match);
        }
    }


}

