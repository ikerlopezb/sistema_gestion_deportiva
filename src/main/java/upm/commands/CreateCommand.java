package upm.commands;

import upm.Player;
import upm.commands.Command;
import upm.PlayerList;

public class CreateCommand extends Command {

    PlayerList playerList;
    //Scanner name = new Scanner(System.in);
    //Player player = new Player(name.next());//Creo que te cogería "create"

    public CreateCommand() {
        super("create");

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
