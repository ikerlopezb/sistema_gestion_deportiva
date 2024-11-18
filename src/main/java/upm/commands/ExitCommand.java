package upm.commands;

import upm.commands.Command;

public class ExitCommand extends Command {

    public ExitCommand(){
        super("exit");
    }
    public void execute(String[] input){
        assert input.length == 1;
        System.out.println("Saliendo del programa...");
    }
}