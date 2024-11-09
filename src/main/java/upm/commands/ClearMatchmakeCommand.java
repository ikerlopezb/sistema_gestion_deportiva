package upm.commands;

import upm.commands.Command;

public class ClearMatchmakeCommand extends Command {

    public ClearMatchmakeCommand(){
        super("clear_matchmake");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
        matches.clear();
    }
}
