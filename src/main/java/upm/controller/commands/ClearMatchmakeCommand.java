package upm.controller.commands;

import upm.controller.Controller;
import upm.list.MatchList;

public class ClearMatchmakeCommand extends Command {
    private MatchList matchList;
    private Controller controller;

    public ClearMatchmakeCommand(Controller controller){
        super("clear_matchmake");
        this.controller = controller;
    }
    public void execute(String[] input){
        assert input.length == 1;
        this.controller.clearMatchmake();

    }
}
