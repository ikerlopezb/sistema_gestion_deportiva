package upm.model;

import java.util.ArrayList;

public class Team implements Participant{
    private ArrayList<Player> team;
    private String teamName;

    public Team(ArrayList<Player> team, String teamName) {
        this.team = team;
        this.teamName = teamName;
    }

    public String getName() {
        return this.teamName;
    }

    
}
