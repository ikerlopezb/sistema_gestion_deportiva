package upm.model;

import upm.Category;

import java.util.ArrayList;
import java.util.Iterator;

public class Team implements Participant{
    private ArrayList<Player> team;
    private String teamName;

    public Team(String teamName) {
        ArrayList<Player> team = new ArrayList<>();
        this.teamName = teamName;
    }

    public String getKey() {
        return this.teamName;
    }
    public void add(Player player){
        this.team.add(player);
    }
    public void remove(Player player) {
        this.remove(player);
    }
    public double getRank(Category category){
        double totalRanking = 0.0;
        for(Player player : this.team){
            totalRanking += player.getRank(category);
        }
        return totalRanking / this.team.size();
    }
    public boolean isPlayerInTeam(Player player){
        return this.team.contains(player);
    }

    public Participant isParticipant(String key) {
        for (Player player : this.team) {
            if (player.getKey().equals(key)) {
                return this;
            }
        }
        return null;
    }



}
