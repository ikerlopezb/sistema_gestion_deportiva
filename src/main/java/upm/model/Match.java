package upm.model;

public class Match {
    private final Participant[] arrayParticipants;

    public Match(Participant[] arrayParticipants) {
        this.arrayParticipants = arrayParticipants;
    }

    public int length(){
        return this.arrayParticipants.length;
    }

    public Participant[] getParticipants() {
        return arrayParticipants;
    }

}
