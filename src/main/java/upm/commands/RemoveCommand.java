package upm.commands;

import upm.Player;
import upm.commands.Command;
import upm.PlayerList;

public class RemoveCommand extends Command {
    private PlayerList playerList;

    public RemoveCommand(PlayerList playerlist) {
        super("remove");
        this.playerList = playerlist;
    }

    public void execute(String[] input) {
        assert input.length == 2;
        Player player = this.playerList.isPlayer(input[1]);
        if(player != null) {
            this.playerList.remove(player);
            System.out.println("Player" + player.getName() + "ha sido eliminado");
        } else {
            System.out.println("Player" + player.getName() + "no existe");
        }
    }
}
