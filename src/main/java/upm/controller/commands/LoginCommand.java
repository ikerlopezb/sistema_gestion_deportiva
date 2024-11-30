package upm.controller.commands;
import upm.LoginVisitor;
import upm.list.AdminList;
import upm.list.PlayerList;
import upm.model.User;

public class LoginCommand extends Command{
    private AdminList adminList;
    private PlayerList playerList;
    public LoginCommand(AdminList adminList, PlayerList playerList) {
        super("login");
        this.adminList = adminList;
        this.playerList = playerList;
    }

    public void execute(String[] input) {
        assert input.length == 3;
        User user = null; //NullPointerException ¿cómo solucionar?
        LoginVisitor visitor = new LoginVisitor();
        user.accept(visitor);
        //como sé al aceptar al visitor si está en mi lista de players o de admins
    }
}
