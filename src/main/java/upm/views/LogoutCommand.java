package upm.views;

public class LogoutCommand extends Command {
    private LoginCommand loginCommand;

    public LogoutCommand() {
        super("logout");
    }

    public void execute(String[] input) {
        assert input.length == 1;
        if (this.loginCommand.getLogged()) {
            this.loginCommand.logout();
        }
    }
}
