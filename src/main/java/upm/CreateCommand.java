package upm;
import java.util.Iterator;
import java.util.Scanner;

public class CreateCommand extends Command {

    //PlayerList playerList = new PlayerList();
    Scanner name  = new Scanner(System.in);
    Player player = new Player(name.next());

    public CreateCommand(PlayerList playerList){
        super("create");
        //this.playerList = playerList;
    }

    public void execute(String input){
        assert isYours(input);
        assert listOfPlayers.size() <= 100;
        if(!exist(player)){
            listOfPlayers.add(player);
        }
    }
    private boolean exist(Player player){
        assert !listOfPlayers.isEmpty();
        Iterator<Player> iterator = listOfPlayers.iterator();
        while(!listOfPlayers.contains(player) && iterator.hasNext()){
            iterator.next();
        }
        return listOfPlayers.contains(player);
    }
}
