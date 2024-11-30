package upm.controller.commands;
import upm.model.Player;
import upm.list.PlayerList;
import upm.model.User;

import java.lang.String;
public class ShowCommand extends Command {
    private PlayerList playerList;

    public ShowCommand(PlayerList playerList){
        super("show");
        this.playerList = playerList;
    }
    public void execute(String[] input) {
        assert input.length == 1;
        for (Player player : this.playerList.getPlayerList()) {
            System.out.println("Name: " + player.getName() + ", Score: " + player.getScore());
        }
    }
}
