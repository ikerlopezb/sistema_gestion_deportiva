package upm.controller.commands;
import upm.controller.Controller;
import upm.list.AdminList;
import upm.list.PlayerList;
import upm.model.User;
import upm.view.CLI;

public class LoginCommand extends Command{
    private Controller controller;
    private boolean logged;


    public LoginCommand(Controller controller) {
        super("login");
        this.controller = controller;
        this.logged = false;
    }

    public void execute(String[] input) {
        assert input.length == 3;
        User user = controller.isUser(input[1], input[2]);
        CLI visitor = new CLI();
        user.accept(visitor);
        this.logged = true;
    }

    public boolean getLogged() {
        return this.logged;
    }
}
