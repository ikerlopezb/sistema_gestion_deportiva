package upm.controller.commands;

import upm.controller.PlayerController;
import upm.controller.TeamController;

public class StatisticsShowCommand extends Command{
    PlayerController playerController;

    public StatisticsShowCommand(PlayerController playerController) {
        super("statistics-show");
        this.playerController = playerController;
    }
    public void execute(String[] input) {

    }
}
