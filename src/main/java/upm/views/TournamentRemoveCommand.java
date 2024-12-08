package upm.views;

import upm.utils.Controller;
import upm.utils.models.Player;
import upm.utils.models.User;


public class TournamentRemoveCommand extends Command {

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
