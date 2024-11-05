package upm;

public class ShowCommand extends Command {

    public ShowCommand(PlayerList playerList){
        super("show");
    }
    public void execute(String input){
        assert isYours(input);
        assert !listOfPlayers.isEmpty();
        for (Player player : listOfPlayers) {
            System.out.println(player);
        }
    }
}
