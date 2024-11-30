package upm.controller;

import upm.Error;
import upm.list.MatchList;
import upm.list.PlayerList;
import upm.model.Player;
import upm.view.ErrorView;

public class AdminController {

    private PlayerList playerList;
    private MatchList matchList;
    private ErrorView error;

    public AdminController(PlayerList playerList, MatchList matchList) {
        this.playerList = playerList;
        this.matchList = matchList;
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
