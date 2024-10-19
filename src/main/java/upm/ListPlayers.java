package upm;

import java.util.*;

public class ListPlayers {

    //final private Player listOfPlayers[] = new Player[100];
    protected List<Player> listOfPlayers = new ArrayList<Player>();
    protected int numPlayers = 0; // puede ser protected al ser atributo o siempre private
    public void create(Player player){
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

    protected boolean exist(Player player){
        assert !listOfPlayers.isEmpty();
        Iterator<Player> iterator = listOfPlayers.iterator();
        while(!listOfPlayers.contains(player) && iterator.hasNext()){
            iterator.next();
        }
        return listOfPlayers.contains(player);
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
}
