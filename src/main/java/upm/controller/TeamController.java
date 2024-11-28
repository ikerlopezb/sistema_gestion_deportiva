package upm.controller;


import upm.model.Team;
import java.util.ArrayList;

public class TeamController {
    private ArrayList<Team> teamList;

    public TeamController(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }

    public void add(Team team) {
        this.teamList.add(team);
    }
}
