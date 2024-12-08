package upm.views;

import upm.utils.Controller;

public class StatisticsShowCommand extends Command {
    private Controller controller;

    public StatisticsShowCommand(Controller controller) {
        super("statistics-show");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 3;
        this.controller.statisticsShow(input[1], input[2]);
    }
}
