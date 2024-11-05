package upm;

public class MatchmakeCommand extends Command {

    public MatchmakeCommand(){
        super("matchmake");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
    }
}
