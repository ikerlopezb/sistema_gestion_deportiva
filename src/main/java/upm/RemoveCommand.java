package upm;

public class RemoveCommand extends Command {

    public RemoveCommand(PlayerList playerList){
        super("remove");
    }
    public void execute(String input){
        assert isYours(input);
        assert exist(player);
        listOfPlayers.remove(player);
    }
}
