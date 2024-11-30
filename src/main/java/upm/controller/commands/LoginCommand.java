package upm.controller.commands;
import upm.LoginVisitor;
import upm.controller.AdminController;
import upm.controller.PlayerController;
import upm.model.Admin;
import upm.model.User;

import java.util.List;

public class LoginCommand extends Command{
    private AdminController adminController;
    private PlayerController playerController;
    public LoginCommand(AdminController adminController, PlayerController playerController) {
        super("login");
        this.adminController = adminController;
        this.playerController = playerController;
    }

    public void execute(String[] input, User user) {
        assert input.length == 3;
        LoginVisitor visitor = new LoginVisitor();
        user.accept(visitor);
        //como sé al aceptar al visitor si está en mi lista de players o de admins
    }
}
