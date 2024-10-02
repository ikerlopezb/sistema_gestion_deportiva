package upm;
/**
 * @author Javier Olmedo Guerra
 * @author Mario Vicente Navarre
 * @author Iker López Bullido
 */

public class AdminView {
    final private Player listOfPlayers[] = new Player[100];
    private int numPlayers = 0;

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
                listOfPlayers[i].setName(" ");
                numPlayers--;
            }
    }

    public void show(){
        for (int i = 0; i < numPlayers - 1; i++) {
            System.out.println(listOfPlayers[i].getName()+ " "+listOfPlayers[i].getScore());
        }
    }

    public void score(Player player,double updateScore) {
        if(updateScore >= -999999.0) {
            player.setScore(updateScore);
        }
    }

    public void rank() {
        boolean ordered = false;
        int gap=this.listOfPlayers.length-1;
        
        if (this.listOfPlayers[0].getScore()>this.listOfPlayers[gap].getScore()) {
            Player aux=listOfPlayers[0];
            this.listOfPlayers[0] = this.listOfPlayers[gap];
            this.listOfPlayers[gap] = aux;
        }

        while (!ordered || gap>1){
            if (gap>1){
                gap=(int) Math.floor(gap/1.3);
                ordered = true;
            }
            int i=0;
            while (i+gap < listOfPlayers.length) {
                if (listOfPlayers[i].getScore() > listOfPlayers[i+gap].getScore()) {
                    Player aux=listOfPlayers[i];
                    listOfPlayers[i] = listOfPlayers[i+gap];
                    listOfPlayers[i+gap] = aux;
                    ordered=false;
                }
            i++;
            }
        }
    }
}
