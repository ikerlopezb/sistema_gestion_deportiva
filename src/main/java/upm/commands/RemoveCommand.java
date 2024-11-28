package upm.commands;

import upm.model.Player;
import upm.PlayerController;

public class RemoveCommand extends Command {
    private PlayerController playerController;

    public RemoveCommand(PlayerController playerlist) {
        super("remove");
        this.playerController = playerlist;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        Player player = this.playerController.isPlayer(input[1]);
        if(player != null) {
            this.playerController.remove(player);
            System.out.println("Player" + player.getName() + "ha sido eliminado");
        } else {
            System.out.println("Player" + player.getName() + "no existe");
        }
    }
}
