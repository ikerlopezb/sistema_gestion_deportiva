package upm;

public class MatchmakeCommand extends Command {

    public MatchmakeCommand(PlayerList playerList){
        super("matchmake");
    }
    public void execute(String input){
        assert isYours(input);
    }
}
