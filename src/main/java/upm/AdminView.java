package upm;

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
}
