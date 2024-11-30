package upm.view;

import upm.controller.AdminController;
import upm.controller.commands.*;
import upm.controller.ControllerCommand;
import upm.controller.MatchController;
import upm.controller.PlayerController;
import upm.controller.commands.LoginCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private final ControllerCommand controllerCommand;

    public CLI() {
        PlayerController playerController = new PlayerController(new ArrayList<>());
        MatchController matchController = new MatchController(playerController);
        AdminController adminController = new AdminController();

        List<Command> commandList = new ArrayList<>();
        commandList.add(new CreateCommand(playerController));
        commandList.add(new RemoveCommand(playerController));
        commandList.add(new RankCommand(playerController));
        commandList.add(new ScoreCommand(playerController));
        commandList.add(new ShowCommand(playerController));
        commandList.add(new MatchmakeCommand(matchController, playerController));
        commandList.add(new RandomMatchmakeCommand(playerController, matchController));
        commandList.add(new ShowMatchmakeCommand(matchController));
        commandList.add(new ClearMatchmakeCommand(matchController));
        commandList.add(new LoginCommand(adminController, playerController));
        commandList.add(new LogoutCommand());
        commandList.add(new ExitCommand());

        this.controllerCommand = new ControllerCommand(commandList);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Introduce el comando");
            input = scanner.nextLine().toLowerCase();
            controllerCommand.processCommand(input);
        } while (!input.startsWith("exit"));
    }

    public static void main(String[] args) {
        new CLI().execute();
    }
}
