package upm.commands;
import upm.Player;
import upm.PlayerList;
import upm.commands.Command;

import java.lang.String;
public class ShowCommand extends Command {
    private PlayerList playerList;

    public ShowCommand(PlayerList playerList){
        super("show");
        this.playerList = playerList;
    }
    public void execute(String[] input){
        assert input.length == 1;
        for(Player player : this.playerList.getPlayerList()){
            System.out.println(player + "\n");
        }
    }
}
