package upm.model;

import java.util.ArrayList;

public class Team implements Participant{
    private ArrayList<Player> team;
    private String teamName;

    public Team(String teamName) {
        ArrayList<Player> team = new ArrayList<>();
        this.teamName = teamName;
    }

    public String getName() {
        return this.teamName;
    }
    public void add(Player player){
        this.team.add(player);
    }


    
}
