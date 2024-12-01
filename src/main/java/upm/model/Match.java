package upm.model;

import upm.model.Player;

public class Match {
    private final Player[] arrayPlayers;

    public Match(Player[] arrayPlayers) {
        this.arrayPlayers = arrayPlayers;
    }

    public int length(){
        return this.arrayPlayers.length;
    }

    public Player[] getPlayers() {
        return arrayPlayers;
    }

}