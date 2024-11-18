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
        return;
    }
}
