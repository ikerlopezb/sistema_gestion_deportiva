package upm.controller.commands;

import upm.model.User;
import upm.view.ErrorView;

import java.util.ArrayList;
import java.util.List;


public abstract class Command{
    private String preffix;

    public Command(String preffix){
        this.preffix = preffix;
    }
    public abstract void execute(String[] input, User user);

    public boolean isYours(String input){
        return input.startsWith(this.preffix);
    }

}