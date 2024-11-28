package upm.commands;

import upm.MatchController;

public class ClearMatchmakeCommand extends Command {
    MatchController matchController;

    public ClearMatchmakeCommand(MatchController matchController){
        super("clear_matchmake");
        this.matchController = matchController;
    }
    public void execute(String[] input){
        assert input.length == 1;
        this.matchController.clear();
    }
}
