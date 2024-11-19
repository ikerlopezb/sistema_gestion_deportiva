package upm.commands;

import upm.commands.Command;
import upm.MatchList;
import java.util.ArrayList;

public class ClearMatchmakeCommand extends Command {
    MatchList matchList;

    public ClearMatchmakeCommand(MatchList matchList){
        super("clear_matchmake");
        this.matchList = matchList;
    }
    public void execute(String[] input){
        assert input.length == 1;
        this.matchList.clear();
    }
}
