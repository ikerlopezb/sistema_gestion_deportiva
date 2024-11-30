package upm.controller.commands;
import upm.model.Player;
import upm.controller.PlayerController;
import upm.model.User;

import java.lang.String;
public class ShowCommand extends Command {
    private PlayerController playerController;

    public ShowCommand(PlayerController playerController){
        super("show");
        this.playerController = playerController;
    }
    public void execute(String[] input, User user) {
        assert input.length == 1;
        for (Player player : this.playerController.getPlayerList()) {
            System.out.println("Name: " + player.getName() + ", Score: " + player.getScore());
        }
    }
}
