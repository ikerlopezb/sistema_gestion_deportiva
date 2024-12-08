package upm.controller.commands;

import upm.controller.Controller;
import upm.model.Player;
import upm.model.User;
import upm.view.CLI;


public class TournamentRemoveCommand extends Command{

    private Controller controller;
    private LoginCommand loginCommand;
    public TournamentRemoveCommand(Controller controller) {
        super("tournament-remove");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        if(loginCommand.getLogged()){
            User user = this.loginCommand.isLogged();
            Player player = user.asPlayer();
            this.controller.tournamentRemove(player);
        }

    }

}
