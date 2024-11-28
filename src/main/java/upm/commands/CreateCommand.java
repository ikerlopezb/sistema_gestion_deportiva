package upm.commands;

import upm.model.Player;
import upm.PlayerController;

public class CreateCommand extends Command {

    private PlayerController playerController;

    public CreateCommand(PlayerController playerController) {
        super("create");
        this.playerController = playerController;
    }

    public void execute(String[] input) {

        assert input.length == 2;
        String playerName = input[1];
        if (this.playerController.isPlayer(playerName) == null) {
            Player player = new Player(playerName);
            playerController.add(player);
            System.out.println("Player " + playerName + " creado.");//Enum error
        } else {
            System.out.println("Player " + playerName + " ya existe.");
        }
    }

}
