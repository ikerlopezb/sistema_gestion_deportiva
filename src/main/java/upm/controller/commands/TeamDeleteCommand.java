package upm.controller.commands;

import upm.controller.TeamController;

public class TeamDeleteCommand extends Command{
    TeamController teamController;

    public TeamDeleteCommand(TeamController teamController) {
        super("team-delete");
        this.teamController = teamController;
    }
    public void execute(String[] input) {

    }
}
