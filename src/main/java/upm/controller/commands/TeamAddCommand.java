package upm.controller.commands;

import upm.controller.TeamController;

public class TeamAddCommand extends Command{
    TeamController teamController;

    public TeamAddCommand(TeamController teamController) {
        super("team-add");
        this.teamController = teamController;
    }
    public void execute(String[] input) {

    }
}
