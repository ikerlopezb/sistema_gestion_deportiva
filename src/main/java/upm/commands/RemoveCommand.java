package upm.commands;

import upm.commands.Command;

public class RemoveCommand extends Command {

    public RemoveCommand(){
        super("remove");
    }
    public void execute(String[] input) {
        assert isYours(input[0]);
        assert exist(player);
        listOfPlayers.remove(player);
    }}
}
