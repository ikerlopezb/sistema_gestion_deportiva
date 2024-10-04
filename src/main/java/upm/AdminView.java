package upm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdminView {
    final private Player listOfPlayers[] = new Player[100];
    private int numPlayers = 0;
    private List<String> matches = new ArrayList<String>();

    public void create(Player player){
        if(this.numPlayers < listOfPlayers.length){
            int i=0;
            while(i<numPlayers && listOfPlayers[i].getName().equals(player.getName()) == false){
                i++;
            }
            if(i == numPlayers){
                listOfPlayers[numPlayers] = player;
                numPlayers++;
            }
        }
    }

    public void remove(String name){
        int i = 0;
        while(i < numPlayers && listOfPlayers[i].getName().equals(name) == false){
            i++;
        }
        if(listOfPlayers[i].getName().equals(name) == true){
            for (; i < numPlayers - 1; i++) {
                listOfPlayers[i] = listOfPlayers[i+1];
            }
            listOfPlayers[i]=null;
            numPlayers--;
        }
    }

    public void show(){
        for (int i = 0; i < numPlayers; i++) {
            System.out.println(listOfPlayers[i].getName()+ " "+listOfPlayers[i].getScore());
        }
    }

    public void score(Player player,double updateScore) {
        if(updateScore >= -999999.0) {
            player.setScore(updateScore);
        }
    }

    public void rank() {
        for (int i = 0; i <this.numPlayers ; i++) {
            for (int j = 0; j <this.numPlayers-1; j++) {
                if(listOfPlayers[j].getScore()<listOfPlayers[j+1].getScore()) {
                    Player aux;
                    aux=listOfPlayers[j];
                    listOfPlayers[j]=listOfPlayers[j+1];
                    listOfPlayers[j+1]=aux;
                }
            }
        }
    }


    public boolean exist(String name){
        boolean found = false;
        int i = 0;
        while(i < this.numPlayers && !found) {
            if(listOfPlayers[i].getName().equals(name)){
                found = true;
            }
            i++;
        }
        return found;
    }
    public boolean paired(String name){
        Iterator<String> iterator = matches.iterator();
        boolean found = false;

        while(iterator.hasNext() && !found){
            if(iterator.next().equals(name)){
                found = true;
            }
        }
        return found;
    }

    public void matchmake(String name1, String name2){
        if(!paired(name1) && exist(name1)){
            if(!paired(name2) && exist(name2)) {
                matches.add(name1);
                matches.add(name2);
            }
        }
    }

    public void clearMatchmake(){
        matches.clear();
    }
    public void showMatchmake(){
        String name1;
        String name2;
        Iterator<String> iterator = matches.iterator();

        while(iterator.hasNext()){
            name1 = iterator.next();
            if (iterator.hasNext()){
                name2 = iterator.next();
                System.out.println(name1 + " vs " + name2);
            }
        }
    }
}
