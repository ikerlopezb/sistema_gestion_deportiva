package upm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SportsManagement {
    final private Player listOfPlayers[] = new Player[100];
    private int numPlayers = 0;




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

                default:
                    System.out.println("El comando introducido no existe");
            }
        }while(running);
    }

    public static void main(String[] args){
        new SportsManagement().menu();
    }


}
