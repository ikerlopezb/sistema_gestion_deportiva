package upm.controller.commands;

import upm.model.User;

import java.util.ArrayList;
import java.util.List;


public abstract class Command {
    private String preffix;
    private List<String> allowedRoles;

    public Command(String preffix, List<String> allowedRoles){
        this.preffix = preffix;
        this.allowedRoles = allowedRoles;
    }
    public abstract void execute(String[] input, User user);

    public boolean isYours(String input){
        return input.startsWith(this.preffix);
    }

    public boolean isAllowed(User user) {
        return allowedRoles.contains(user.getRole());
    }
}