package upm.model;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> team;
    private String teamName;

    public Team(ArrayList<Player> team, String teamName) {
        this.team = team;
        this.teamName = teamName;
    }
}
