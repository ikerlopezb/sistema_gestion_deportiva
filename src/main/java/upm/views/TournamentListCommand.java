package upm.views;

import upm.utils.Controller;
import upm.utils.models.User;

public class TournamentListCommand extends Command {

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
