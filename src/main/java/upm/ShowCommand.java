package upm;
import java.lang.String;
public class ShowCommand extends Command {

    public ShowCommand(){
        super("show");
    }
    public void execute(String[] input){
        assert isYours(input[0]);
        if (listOfPlayers.isEmpty()) {
            System.out.println("No hay jugadores en el sistema.");
            return;
        }
        for (Player player : listOfPlayers) {
            System.out.println(player.getName());
        }
    }
}
