package upm.controller.commands;
import upm.model.User;

import java.util.List;

public class LoginCommand extends Command{

    public LoginCommand() {
        super("login", List.of("Player", "Admin"));
    }

    public void execute(String[] input, User user) {
        assert input.length == 1;
        
    }
}
