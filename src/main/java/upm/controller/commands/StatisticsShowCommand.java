package upm.controller.commands;

import upm.controller.Controller;

public class StatisticsShowCommand extends Command{
    private Controller controller;

    public StatisticsShowCommand(Controller controller) {
        super("statistics-show");
        this.controller = controller;
    }
    public void execute(String[] input) {

    }
}
