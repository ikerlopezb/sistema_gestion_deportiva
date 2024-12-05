package upm.list;

import upm.model.Player;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerList {
    private ArrayList<Player> playerList;

    public PlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public Player isPlayer(String DNI) {
        if (!this.playerList.isEmpty()) {
            Iterator<Player> iterator = this.playerList.iterator();
            Player player = iterator.next();

            while (iterator.hasNext() && !(player.getDNI().equals(DNI))) {
                player = iterator.next();
            }

            return (player.getDNI().equals(DNI)) ? player: null;
        } else {
            return null;
        }
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public boolean containsPlayer(Player player) {
        return this.playerList.contains(player);
    }

    public int size() {
        return this.playerList.size();
    }

    public void removePlayer(Player player) {
        this.playerList.remove(player);
    }

    public Player getIndex(int i) {
        return this.playerList.get(i);
    }

}
