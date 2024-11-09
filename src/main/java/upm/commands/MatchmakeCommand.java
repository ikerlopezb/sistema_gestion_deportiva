package upm.commands;

import upm.commands.Command;

public class MatchmakeCommand extends Command {

    public MatchmakeCommand(){
        super("matchmake");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
    }
}
