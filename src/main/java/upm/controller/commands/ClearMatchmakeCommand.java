package upm.controller.commands;

import upm.controller.AdminController;
import upm.list.MatchList;

public class ClearMatchmakeCommand extends Command {
    private MatchList matchList;
    private AdminController adminController;

    public ClearMatchmakeCommand(AdminController adminController){
        super("clear_matchmake");
        this.adminController = adminController;
    }
    public void execute(String[] input){
        assert input.length == 1;
        this.adminController.clearMatchmake();

    }
}
