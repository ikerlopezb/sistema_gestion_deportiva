package upm.commands;
import upm.Player;
import upm.PlayerList;
import upm.commands.Command;

import java.lang.String;
public class ShowCommand extends Command {
    private PlayerList playerList;

    public ShowCommand(PlayerList p){
        super("show");
    }
    public void execute(String[] input){
        return;
    }
}
