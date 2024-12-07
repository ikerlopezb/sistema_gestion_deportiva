package upm.controller.commands;

import upm.controller.Controller;
import upm.model.User;


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
            this.controller.tournamentRemove(user);
        }

    }

}
