package upm.view;

import upm.list.AdminList;
import upm.controller.AdminController;
import upm.controller.PlayerController;
import upm.controller.commands.*;
import upm.controller.ControllerCommand;
import upm.list.MatchList;
import upm.list.PlayerList;
import upm.controller.commands.LoginCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private final ControllerCommand controllerCommand;

    public CLI() {
        PlayerList playerList = new PlayerList(new ArrayList<>());
        MatchList matchList = new MatchList(playerList);
        AdminList adminList = new AdminList();
        AdminController adminController = new AdminController(playerList, matchList);
        PlayerController playerController = new PlayerController(playerList);

        List<Command> commandList = new ArrayList<>();
        commandList.add(new CreateCommand(playerController));
        commandList.add(new RemoveCommand(playerList));
        commandList.add(new RankCommand(playerList));
        commandList.add(new ScoreCommand(playerList));
        commandList.add(new ShowCommand(playerList));
        commandList.add(new MatchmakeCommand(matchList, playerList));
        commandList.add(new RandomMatchmakeCommand(playerList, matchList));
        commandList.add(new ShowMatchmakeCommand(matchList));
        commandList.add(new ClearMatchmakeCommand(matchList));
        commandList.add(new LoginCommand(adminList, playerList));
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
