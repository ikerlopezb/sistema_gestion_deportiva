package upm;

import java.util.*;

public class PlayerList {
    private ArrayList<Player> playerList;

    public PlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public Player isPlayer(String playerName) {
        if (!this.playerList.isEmpty()) {
            Iterator<Player> iterator = this.playerList.iterator();
            Player player = iterator.next();

            while (iterator.hasNext() && !(player.getName().equals(playerName))) {
                player = iterator.next();
            }

            return (player.getName().equals(playerName)) ? player: null;
        } else {
            return null;
        }
    }

    public void add(Player player) {
        this.playerList.add(player);
    }

    public boolean contains(Player player) {
        return this.playerList.contains(player);
    }

    public int size() {
        return this.playerList.size();
    }

    public void remove(Player player) {
        this.playerList.remove(player);
    }

    public Player getIndex(int i) {
        return this.playerList.get(i);
    }

}
