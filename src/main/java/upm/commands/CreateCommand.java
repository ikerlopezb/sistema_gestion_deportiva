package upm.commands;
import upm.Player;
import upm.commands.Command;

public class CreateCommand extends Command {

    //PlayerList playerList = new PlayerList();
    //Scanner name = new Scanner(System.in);
    //Player player = new Player(name.next());//Creo que te cogería "create"

    public CreateCommand() {
        super("create");

    }

    public void execute(String[] input) {

        if (input.length != 2) {
            System.out.println("Formato incorrecto. Use: create [player]");
            return;
        }
        String playerName = input[1];
        Player player = new Player(playerName);
        if (!listOfPlayers.contains(player)) {
            listOfPlayers.add(player);
            System.out.println("Player " + playerName + " creado.");
        } else {
            System.out.println("Player " + playerName + " ya existe.");
        }
    }

    /*
    public void execute(String[] inputParts) {
        assert isYours(inputParts);
        assert listOfPlayers.size() <= 100;
        if (!exist(player)) {
            listOfPlayers.add(player);
        }
    }

    private boolean exist(Player player) {
        assert !listOfPlayers.isEmpty();
        Iterator<Player> iterator = listOfPlayers.iterator();
        while (!listOfPlayers.contains(player) && iterator.hasNext()) {
            iterator.next();
        }
        return listOfPlayers.contains(player);
    }

     */
}
