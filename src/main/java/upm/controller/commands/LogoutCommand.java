package upm.controller.commands;

import upm.model.User;

import java.util.List;

public class LogoutCommand extends Command{

    public LogoutCommand(String preffix){
        super("logout", List.of("Player", "Admin"));
    }

    public void execute(String[] input, User user){

    }
}
