package upm.views;

import upm.utils.Controller;

public class ClearMatchmakeCommand extends Command {
    private Controller controller;

    public ClearMatchmakeCommand(){
        super("clear_matchmake");
        this.controller = controller;
    }
    public void execute(String[] input){
        assert input.length == 1;
        controller.clearMatchmake();
    }
}
