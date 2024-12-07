package upm.controller.commands;

import upm.controller.Controller;
import upm.model.User;
import upm.view.CLI;

public class TournamentListCommand extends Command{

    private Controller controller;
    private LoginCommand loginCommand;
    private CLI visitor;
    private User user;

    public TournamentListCommand(Controller controller) {
        super("tournament-list");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        if(loginCommand.getLogged()){
            user.tournamentList(visitor);
        }
        else {
            this.controller.showShuffleTournamentList();
        }
    }
}
