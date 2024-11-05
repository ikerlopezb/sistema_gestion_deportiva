package upm;

public class ClearMatchmake extends Command {

    public ClearMatchmake(PlayerList playerList){
        super("clear_matchmake");
    }
    public void execute(String input){
        assert isYours(input);
        matches.clear();
    }
}
