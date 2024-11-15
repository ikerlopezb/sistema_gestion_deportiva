package upm;

import java.util.*;

public class PlayerList {
    private List<Player> playerList = new ArrayList<Player>();//Debe ser en este caso protected un atributo?

    public List<Player> getPlayerList() {
        return playerList;
    }

    public boolean existPlayer(Player player) {
        assert !playerList.isEmpty();
        Iterator<Player> iterator = playerList.iterator();
        while ((iterator.next().getName().equals(player.getName())) && iterator.hasNext()) {
            iterator.next();
        }
        return playerList.contains(player);
    }

    public Player isPlayer (String playerName){
        assert !playerList.isEmpty();
        Iterator<Player> iterator = playerList.iterator();
        while((iterator.next().getName().equals(playerName)) && iterator.hasNext()){
            iterator.next();
        }
        return(iterator.next().getName().equals(playerName)) ? iterator.next() : null;//Iker
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
