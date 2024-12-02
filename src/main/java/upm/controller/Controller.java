package upm.controller;

import upm.Error;
import upm.Tournament;
import upm.list.*;
import upm.model.Player;
import upm.view.ErrorView;

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
}
