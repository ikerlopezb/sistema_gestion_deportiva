package upm.controller.commands;

public class TeamCreateCommand extends Command {
    TeamController teamController;

    public TeamCreateCommand(TeamController teamController) {
        super("team-create");
        this.teamController = teamController;
    }
    public void execute(String[] input) {

    }

}
