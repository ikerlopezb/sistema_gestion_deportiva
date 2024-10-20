package upm;

public class Create extends SportsManagement {
    if (firstCommandParts.length == 2) {
        String playerName = firstCommandParts[1].trim();
        Player newPlayer = new Player(playerName);
        create(newPlayer);
        System.out.println("Jugador " + playerName + " ha sido creado.");
    } else {
        error(0);
    }
}
