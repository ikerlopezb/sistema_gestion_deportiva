package upm.controller;

import upm.controller.commands.Command;
import upm.Error;
import java.util.List;
import upm.view.ErrorView;


public class ControllerCommand {

    private final List<Command> commandList;
    private ErrorView error;

    public ControllerCommand(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void processCommand(String input, User user) {
        String commandName = input.split(" ")[0].trim();
        for (Command command : commandList) {
            if (command.isYours(commandName)) {
                command.execute(input.split("[\\s;]+"));
                error.writeln(Error.NULL);
            }
        }
        error.writeln(Error.COMMAND_NOT_FOUND);
    }
}
