package upm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tournament {
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

    public void score(String namePlayer,double updateScore) {
        int i = 0;
        assert updateScore >= -999999.0;
        if(exist(namePlayer)){
            while(!listOfPlayers[i].getName().equals(namePlayer)) {
                i++;
            }
            listOfPlayers[i].setScore(updateScore);
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


    private boolean exist(String name){
        int i = 0;
        boolean found = false;
        while(i < this.numPlayers && !found) {
            if(listOfPlayers[i].getName().equals(name))
                found = true;
            i++;
        }
        return found;
    }
    private boolean paired(String name){
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

    public void randomMatchmake(){
        if(this.numPlayers % 2 == 0) {
            int i;
            do {
                i = matchmake();
                matches.add(this.listOfPlayers[i].getName());
            } while (matches.size() < this.numPlayers);
        }

    }

    private int matchmake(){
        Random random = new Random();
        int i = random.nextInt(this.numPlayers);
        if(paired(this.listOfPlayers[i].getName())) {
            return matchmake();
        }
        return i;
    }
    private void error(int method){
        String[] methodNames = new String[] {"create [player]", "remove [player]", "show", "score [player];[score]",
                "rank", "matchmake [player1];[player2]", "clear_matchmake", "show_matchmake", "random_matchmake"};

        System.out.println("Formato incorrecto. Use " + methodNames[method]);
    }

    private void menu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        scanner.useDelimiter("\n");

        do{
            System.out.println("Introduzca un comando: ");
            String commandLine = scanner.nextLine().trim().toLowerCase();
            Scanner commandScanner = new Scanner(commandLine).useDelimiter(";");
            String firstPart = commandScanner.next().trim();

            String[] firstCommandParts = firstPart.split("\\s+");
            String command = firstCommandParts[0];

            switch(command){
                case "create":
                    if (firstCommandParts.length == 2) {
                        String playerName = firstCommandParts[1].trim();
                        Player newPlayer = new Player(playerName);
                        create(newPlayer);
                        System.out.println("Jugador " + playerName + " ha sido creado.");
                    } else {
                        error(0);
                    }
                    break;

                case "remove":
                    if (firstCommandParts.length == 2) {
                        String playerName = firstCommandParts[1].trim();
                        remove(playerName);
                        System.out.println("Jugador " + playerName + " ha sido eliminado.");
                    } else {
                        error(1);
                    }
                    break;

                case "show":
                    if (firstCommandParts.length == 1) {
                        show();
                    } else {
                        error(2);
                    }
                    break;

                case "score":
                    if (commandScanner.hasNext()) {
                        String playerName = firstCommandParts[1].trim();
                        double score = Double.parseDouble(commandScanner.next().trim());
                        if (exist(playerName)) {
                            score(playerName, score);
                            System.out.println("Puntuación de " + score + " asignada a " + playerName);
                        } else {
                            System.out.println("El jugador " + playerName + " no existe.");
                        }
                    } else {
                        error(3);
                    }
                    break;

                case "rank":
                    if (firstCommandParts.length == 1) {
                        rank();
                    } else {
                        error(4);
                    }
                    break;

                case "matchmake":
                    if (commandScanner.hasNext()) {
                        String player1 = firstCommandParts[1].trim();
                        String player2 = commandScanner.next().trim();
                        matchmake(player1, player2);
                        System.out.println("Partida creada entre " + player1 + " y " + player2);
                    } else {
                        error(5);
                    }
                    break;

                case "clear_matchmake":
                    if(firstCommandParts.length == 1){
                        clearMatchmake();
                    }
                    else{
                        error(6);
                    }
                    break;

                case "show_matchmake":
                    if(firstCommandParts.length == 1){
                        showMatchmake();
                    }
                    else{
                        error(7);
                    }
                    break;

                case "random_matchmake":
                    if(firstCommandParts.length == 1){
                        randomMatchmake();
                    }
                    else{
                        error(8);
                    }
                    break;

                case "exit":
                    running = false;
                    System.out.println("Finalizado correctamente.");
                    break;
            }
        }while(running);
    }

    public static void main(String[] args){
        new Tournament().menu();
    }


}
