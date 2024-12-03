package upm.controller;

import upm.Error;
import upm.Tournament;
import upm.list.*;
import upm.model.Player;
import upm.model.Team;
import upm.view.ErrorView;

import java.util.ArrayList;

public class Controller {

    private PlayerList playerList;
    private MatchList matchList;
    private AdminList adminList;
    private TeamList teamList;
    private TournamentList tournamentlist;
    private ErrorView error;

    public Controller(PlayerList playerList, MatchList matchList, TeamList teamList, AdminList adminList,
                      TournamentList tournamentList) {
        this.playerList = playerList;
        this.matchList = matchList;
        this.teamList = teamList;
        this.adminList = adminList;
        this.tournamentlist = tournamentList;
    }
    public void createPlayer(String playerName){
        if (this.playerList.isPlayer(playerName) == null) {
            Player player = new Player(playerName);
            playerList.addPlayer(player);
        } else {
            error.writeln(Error.PLAYER_ALREADY_EXISTS);
        }
    }

    public void clearMatchmake(){
        this.matchList.clearmatchList();
    }

    public void deletePlayer(String playerName){
        Player player = this.playerList.isPlayer(playerName);
        if(player != null) {
            this.playerList.removePlayer(player);
        } else {
            error.writeln(Error.PLAYER_NOT_FOUND);
        }
    }

    public void teamCreate(String teamName) {
        assert !this.teamList.existTeam(teamName);
        Team team = new Team(teamName);
        this.teamList.add(team);
    }

    public void teamAdd(String teamName, String playerName){
        Player player = this.playerList.isPlayer(playerName);
        if(this.teamList.existTeam(teamName) && player != null){
            Team team = this.teamList.isTeam(teamName);
            team.add(player);
        }
    }

    public void teamDelete(String teamName) {
        assert this.teamList.existTeam(teamName);
        Team team = this.teamList.isTeam(teamName);
        //isCompeting hay que usar pero falta por pensar otro método
    }




    public void teamRemove(String teamName, String playerName) {

    }

}
