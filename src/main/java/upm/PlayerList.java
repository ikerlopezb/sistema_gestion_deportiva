package upm;

import java.util.*;

public class PlayerList {
    private ArrayList<Player> playerList;

    public PlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /*public boolean existPlayer(Player player) {
        assert !playerList.isEmpty();
        Iterator<Player> iterator = playerList.iterator();
        while ((iterator.next().getName().equals(player.getName())) && iterator.hasNext()) {
            iterator.next();
        }
        return playerList.contains(player);
    }*/

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





    /*public void create(Player player){
        assert listOfPlayers.size() <= 100;
        if(!exist(player)){
            listOfPlayers.add(player);
        }
    }

    public void remove(Player player){
        assert exist(player);
        listOfPlayers.remove(player);
    }

    public void show(){
        assert !listOfPlayers.isEmpty();
        for (Player player : listOfPlayers) {
            System.out.println(player);
        }
    }




    public void score(Player player,double updateScore) {
        assert updateScore >= -999999.0;
        if(exist(player)){
            player.setScore(updateScore);
        }
    }


    public void rank() {
        Collections.sort(listOfPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return Double.compare(player2.getScore(), player1.getScore());
            }
        });
    }
    */
}
