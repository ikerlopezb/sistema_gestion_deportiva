package upm;

public class ExitCommand extends Command{

    public ExitCommand(){
        super("exit");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
    }
}
