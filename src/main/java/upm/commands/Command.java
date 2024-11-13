package upm.commands;

import upm.Player;
import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    private String preffix;
    //protected List<Player> listOfPlayers = new ArrayList<Player>();

    public Command(String preffix){
        this.preffix = preffix;
    }
    public abstract void execute(String[] input);

    public boolean isYours(String input){
        return input.startsWith(this.preffix);
    }
}