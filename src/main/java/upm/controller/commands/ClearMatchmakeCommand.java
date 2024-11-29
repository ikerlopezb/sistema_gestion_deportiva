package upm.controller.commands;

import upm.controller.MatchController;

public class ClearMatchmakeCommand extends Command {
    private MatchController matchController;

    public ClearMatchmakeCommand(MatchController matchController){
        super("clear_matchmake");
        this.matchController = matchController;
    }
    public void execute(String[] input){
        assert input.length == 1;
        this.matchController.clearmatchList();
    }
}
