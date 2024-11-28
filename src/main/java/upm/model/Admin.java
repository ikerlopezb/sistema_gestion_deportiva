package upm.model;

import java.util.ArrayList;


public class Admin extends User {
    private ArrayList<Player> registeredPlayers;
    private ArrayList<Team> registeredTeams;


    public Admin(String email, String password){
        super(email, password);
        this.registeredPlayers = new ArrayList<>();
        this.registeredTeams = new ArrayList<>();
    }

    public ArrayList<Player> getRegisteredPlayers() {
        return this.registeredPlayers;
    }

    public ArrayList<Team> getRegisteredTeams() {
        return this.registeredTeams;
    }
    public String getRole() {
        return "Admin";
    }
}
