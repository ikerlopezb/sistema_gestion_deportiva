package upm.utils;

import upm.utils.models.Participant;
import upm.utils.models.Player;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerList {
    private ArrayList<Player> playerList;

    public PlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Player isPlayer(String email, String password) {
        Iterator<Player> iterator = this.playerList.iterator();
        Player playerInList = iterator.next();

        while (!playerInList.getEmail().equals(email) &&
                !playerInList.getPassword().equals(password) && iterator.hasNext()) {
            playerInList = iterator.next();
        }
        return (playerInList.getEmail().equals(email) &&
                playerInList.getPassword().equals(password)) ? playerInList : null;
    }

    public Player isPlayer(String key) {
        Iterator<Player> iterator = this.playerList.iterator();
        Player player = iterator.next();
        while (!player.getKey().equals(key) && iterator.hasNext()) {
            iterator.next();
        }
        return player.getKey().equals(key) ? player : null;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }


    public void removePlayer(Player player) {
        this.playerList.remove(player);
    }


    public Participant isParticipantPlayer(String key) {
        Iterator<Player> iterator = this.playerList.iterator();
        Player player = iterator.next();
        while (!player.getKey().equals(key) && iterator.hasNext()) {
            iterator.next();
        }
        return player.getKey().equals(key) ? player : null;
    }

}
