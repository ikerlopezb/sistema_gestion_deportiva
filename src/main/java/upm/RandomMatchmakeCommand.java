package upm;

public class RandomMatchmakeCommand extends Command {

    public RandomMatchmakeCommand(){
        super("random_matchmake");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
    }
}
