package upm;

public class RandomMatchmakeCommand extends Command {

    public RandomMatchmakeCommand(PlayerList playerList){
        super("random_matchmake");
    }
    public void execute(String input){
        assert isYours(input);
    }
}
