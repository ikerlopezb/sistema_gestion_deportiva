package upm.utils;

import upm.utils.models.Participant;
import upm.utils.models.Player;
import upm.utils.models.Team;

import java.util.Iterator;
import java.util.List;

public class TeamList {
    private List<Team> teamList;

    public TeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public boolean existTeam(String teamName) {
        Iterator<Team> iterator = teamList.iterator();
        Team team = iterator.next();
        while (!team.getKey().equals(teamName) && iterator.hasNext()) {
            team = iterator.next();
        }
        return team.getKey().equals(teamName);
    }

    public void add(Team team) {
        this.teamList.add(team);
    }

    public Team isTeam(String teamName) {
        if (!this.teamList.isEmpty()) {
            Iterator<Team> iterator = this.teamList.iterator();
            Team team = iterator.next();

            while (iterator.hasNext() && !(team.getKey().equals(teamName))) {
                team = iterator.next();
            }
            return (team.getKey().equals(teamName)) ? team : null;
        } else {
            return null;
        }
    }

    public Team whichTeam(Player player) {
        Iterator<Team> iterator = this.teamList.iterator();
        Team team = iterator.next();

        while (!team.isPlayerInTeam(player) && iterator.hasNext()) {
            team = iterator.next();
        }
        return team;
    }

    public Participant isParticipantTeam(String key) {
        Iterator<Team> iterator = this.teamList.iterator();
        Team team = iterator.next();
        while (!team.getKey().equals(key) && iterator.hasNext()) {
            iterator.next();
        }
        return team.getKey().equals(key) ? team : null;
    }
}
