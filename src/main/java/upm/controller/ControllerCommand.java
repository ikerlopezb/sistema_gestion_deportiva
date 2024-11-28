package upm.controller;

import upm.controller.commands.Command;
import upm.Error;
import java.util.List;

public class ControllerCommand {

    private final List<Command> commandList;

    public ControllerCommand(List<Command> commandList) {
        this.commandList = commandList;
    }

    public Error processCommand(String input) {
        String commandName = input.split(" ")[0].trim();
        for (Command command : commandList) {
            if (command.isYours(commandName)) {
                command.execute(input.split("[\\s;]+"));
                return Error.NULL;
            }
        }
        return Error.COMMAND_NOT_FOUND; // Error si no se encuentra el comando
    }
}
