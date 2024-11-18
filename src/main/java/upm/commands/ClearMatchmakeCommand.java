package upm.commands;

import upm.commands.Command;
import upm.MatchList;

public class ClearMatchmakeCommand extends Command {
    MatchList matchList;

    public ClearMatchmakeCommand(){
        super("clear_matchmake");
    }
    public void execute(String[] input){
        assert input.length == 1;
        matchList.getMatches().clear();
    }
}w
