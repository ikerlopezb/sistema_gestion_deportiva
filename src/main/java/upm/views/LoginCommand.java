package upm.views;

import upm.utils.Controller;
import upm.utils.models.User;

public class LoginCommand extends Command {
    private Controller controller;
    private boolean logged;
    private User user;


    public LoginCommand(Controller controller) {
        super("login");
        this.controller = controller;
        this.logged = false;
    }

    public void execute(String[] input) {
        assert input.length == 3;
        user = controller.isUser(input[1], input[2]);
        if (user != null) {
            CLI visitor = new CLI();
            user.accept(visitor);
            this.logged = true;
        }

    }

    public boolean getLogged() {
        return this.logged;
    }

    public User isLogged() {
        return this.user;
    }

    public void logout() {
        this.logged = false;
        this.user = null;
    }
}
