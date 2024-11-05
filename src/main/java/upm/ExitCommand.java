package upm;

public class ExitCommand extends Command{

    public ExitCommand(PlayerList playerList){
        super("exit");
    }
    public void execute(String input){
        assert isYours(input);
    }
}
