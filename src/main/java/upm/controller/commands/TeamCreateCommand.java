package upm.controller.commands;

import upm.controller.TeamController;

public class TeamCreateCommand extends Command {
    TeamController teamController;

    public TeamCreateCommand(TeamController teamController) {
        super("team-create");
        this.teamController = teamController;
    }
    public void execute(String[] input) {

    }

}
