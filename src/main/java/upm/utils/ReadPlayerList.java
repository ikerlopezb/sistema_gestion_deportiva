package upm.utils;

import upm.utils.models.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.in;

public class ReadPlayerList extends Reader {
    private PlayerList playerList;
    private final BufferedReader in;

    public ReadPlayerList(PlayerList playerList, BufferedReader in){
        super("Player");
        this.playerList = playerList;
        this.in = in;
    }


    public void read(String input) throws IOException {
        if (this.isYours(input)) {
            try (this.in) {
                String linea = this.findLabel(in) + 1 ;
                while (linea != null && linea.length() > 1) {
                    String[] parts = linea.split(";");
                    if (parts.length == 5) {
                        String forename = parts[0].trim();
                        String surname = parts[1].trim();
                        String key = parts[2].trim();
                        String email = parts[3].trim();
                        String password = parts[4].trim();
                        Player player = new Player(forename, surname, key, email, password);
                        playerList.addPlayer(player);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
