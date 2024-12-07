package upm.controller.commands;
import upm.controller.Controller;
import upm.list.AdminList;
import upm.list.PlayerList;
import upm.model.User;
import upm.view.CLI;

public class LoginCommand extends Command{
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
        if(user != null){
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
}
