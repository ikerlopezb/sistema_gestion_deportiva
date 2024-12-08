package upm.utils.models;

import upm.utils.VisitorUser;

import java.util.ArrayList;


public class Admin extends User {
    private ArrayList<Player> registeredPlayers;
    private ArrayList<Team> registeredTeams;


    public Admin(String email, String password){
        super(email, password);
        this.registeredPlayers = new ArrayList<>();
        this.registeredTeams = new ArrayList<>();
    }

    public String getRole() {
        return "Admin";
    }
    public void accept(VisitorUser visitor){
        visitor.visit(this);
    }

    public void tournamentList(VisitorUser visitor) {
        visitor.tournamentList(this);
    }
}
