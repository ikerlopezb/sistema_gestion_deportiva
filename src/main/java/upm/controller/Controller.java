package upm.controller;

import upm.Category;
import upm.Error;
import upm.Tournament;
import upm.list.*;
import upm.model.Admin;
import upm.model.Player;
import upm.model.Team;
import upm.model.User;
import upm.view.ErrorView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

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
    public void createPlayer(String DNI){
        if (this.playerList.isPlayer(DNI) == null) {
            Player player = new Player(DNI);
            playerList.addPlayer(player);
        } else {
            error.writeln(Error.PLAYER_ALREADY_EXISTS);
        }
    }

    public void clearMatchmake(){
        this.matchList.clearmatchList();
    }

    public void deletePlayer(String DNI){
        Player player = this.playerList.isPlayer(DNI);
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

    public void teamAdd(String teamName, String DNI){
        Player player = this.playerList.isPlayer(DNI);
        if(this.teamList.existTeam(teamName) && player != null){
            Team team = this.teamList.isTeam(teamName);
            team.add(player);
        }
    }

    public void teamDelete(String teamName) {
        assert this.teamList.existTeam(teamName);
        Team team = this.teamList.isTeam(teamName);
        if(!this.tournamentlist.isCompeting(team)){
            Tournament tournament = this.tournamentlist.getTournamentTeam(team);
            tournament.remove(team);
        }
    }
    public void teamRemove(String teamName, String DNI) {
        Player player = this.playerList.isPlayer(DNI);
        if(this.teamList.existTeam(teamName) && player != null){
            Team team = this.teamList.isTeam(teamName);
            team.remove(player);
        }
    }

    public void tournamentAdd(String participant, String tournamentName) {
        if((this.teamList.existTeam(participant) || this.playerList.isPlayer(participant) != null) &&
                (this.tournamentlist.isTournament(tournamentName) != null)){
            Tournament tournament = this.tournamentlist.isTournament(tournamentName);
            this.tournamentlist.add(tournament);
        }
    }

    public void tournamentCreate(String tournamentName, String startDate,
                                 String endDate, String rankingCategory) {

        assert this.tournamentlist.isTournament(tournamentName) == null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        Category category = Category.valueOf(rankingCategory);
        Tournament tournament = new Tournament(tournamentName, start, end, category);
        this.tournamentlist.add(tournament);
    }

    public void tournamentDelete(String tournamentName) {
        assert this.tournamentlist.isTournament(tournamentName) != null;
        Tournament tournament = this.tournamentlist.isTournament(tournamentName);
        this.tournamentlist.remove(tournament);
    }

    public void showShuffleTournamentList(){
        for(Tournament tournament : this.tournamentlist.getTournamentList()) {
            System.out.println(tournament.getTournamentName());
            tournament.showShuffleParticipants();
        }
    }

    public void showTournamentList(){
        for(Tournament tournament : this.tournamentlist.getTournamentList()) {
            System.out.println(tournament.getTournamentName());
            tournament.showRankingParticipants();
        }
    }
    public void removeFinishedTournaments(){
        for(Tournament tournament : this.tournamentlist.getTournamentList()){
            if(tournament.getEndDate().isBefore(LocalDate.now())){
                this.tournamentlist.remove(tournament);
            }
        }
    }
    public User isUser(String email, String password){
        User user = null;
        Admin admin = this.adminList.isAdmin(email, password);
        if(admin == null){
            user = this.playerList.isPlayer(email, password);
        }
        return user;
    }
    public void tournamentRemove(){
        User user;

    }


}
