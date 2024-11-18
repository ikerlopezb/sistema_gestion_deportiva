package upm.commands;

import upm.Player;
import upm.commands.Command;
import upm.PlayerList;
import java.util.ArrayList;
public class CreateCommand extends Command {

    private PlayerList playerList;

    public CreateCommand(PlayerList playerList) {
        super("create");
        this.playerList = playerList;
    }

    public void execute(String[] input) {

        assert input.length == 2;
        String playerName = input[1];
        Player player = new Player(playerName);
        if (!playerList.getPlayerList().contains(player)) {
            playerList.getPlayerList().add(player);
            System.out.println("Player " + playerName + " creado.");//Preguntar si está bien poner un print en execute
        } else {
            System.out.println("Player " + playerName + " ya existe.");
        }
    }

}
