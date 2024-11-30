package upm.controller.commands;

import upm.model.User;

import java.util.List;

public class ExitCommand extends Command {

    public ExitCommand(){
        super("exit");
    }
    public void execute(String[] input, User user){
        assert input.length == 1;
        System.out.println("Saliendo del programa...");
    }
}
