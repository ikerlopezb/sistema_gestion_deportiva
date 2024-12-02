package upm.view;

import upm.Error;
import upm.VisitorUser;
import upm.list.AdminList;
import upm.controller.Controller;
import upm.controller.commands.*;
import upm.list.MatchList;
import upm.list.PlayerList;
import upm.controller.commands.LoginCommand;
import upm.model.Admin;
import upm.model.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CLI implements VisitorUser {
    private final ControllerCommand controllerCommand;
    private List<Command> enabledCommands;
    private ErrorView error;
    private List<Command> commandList = new ArrayList<>();


    public CLI() {
        PlayerList playerList = new PlayerList(new ArrayList<>());
        MatchList matchList = new MatchList(playerList);
        AdminList adminList = new AdminList();
        Controller controller = new Controller(playerList, matchList);
        PlayerController playerController = new PlayerController(playerList);


        this.commandList.add(new CreateCommand(playerController));
        this.commandList.add(new RemoveCommand(playerList));
        this.commandList.add(new RankCommand(playerList));
        this.commandList.add(new ScoreCommand(playerList));
        this.commandList.add(new ShowCommand(playerList));
        this.commandList.add(new MatchmakeCommand(matchList, playerList));
        this.commandList.add(new RandomMatchmakeCommand(playerList, matchList));
        this.commandList.add(new ShowMatchmakeCommand(matchList));
        this.commandList.add(new ClearMatchmakeCommand(matchList));
        this.commandList.add(new LoginCommand(adminList, playerList));
        this.commandList.add(new LogoutCommand());
        this.commandList.add(new ExitCommand());
        /*Esta lista de comandos sobra, iría en el visit de Player y de Admin.
          En el constructor del CLI solo va Controller controller = new Controller(Playerlist, MatchList, TeamList)
        */
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Introduce el comando");
            input = scanner.nextLine().toLowerCase();
            String commandName = input.split(" ")[0].trim();
            Iterator<Command> iterator = commandList.iterator();
            Command command = iterator.next();

            while (!command.isYours(commandName) && iterator.hasNext()) {
                command = iterator.next();
            }
            if (command.isYours(commandName)) {
                command.execute(input.split("[\\s;]+"));
                error.writeln(upm.Error.NULL);
            } else {
                error.writeln(Error.COMMAND_NOT_FOUND);
            }


        } while (!input.startsWith("exit"));
    }

    public void visit(Player player) {
        enabledCommands.add(new StatisticsShowCommand(Controller));// lo mismo que en el visit de admin
    }
    public void visit(Admin admin) {
        enabledCommands.add(new CreateCommand(Controller));
        // así con todos los comandos que pueda ejecutar admin
    }

    public static void main(String[] args) {
        new CLI().execute();
    }
}
