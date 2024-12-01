package upm.controller.commands;

import upm.controller.TeamController;

public class TeamRemoveCommand extends Command{
    TeamController teamController;

    public TeamRemoveCommand(TeamController teamController) {
        super("team-remove");
        this.teamController = teamController;
    }
    public void execute(String[] input) {

    }
}
