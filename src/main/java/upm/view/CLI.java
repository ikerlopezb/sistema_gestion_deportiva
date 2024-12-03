package upm.view;

import upm.Error;
import upm.VisitorUser;
import upm.list.*;
import upm.controller.Controller;
import upm.controller.commands.*;
import upm.controller.commands.LoginCommand;
import upm.model.Admin;
import upm.model.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CLI implements VisitorUser {
    private Controller controller;
    private List<Command> enabledCommands;
    private ErrorView error;
    private List<Command> commandList = new ArrayList<>();


    public CLI() {
        PlayerList playerList = new PlayerList(new ArrayList<>());
        MatchList matchList = new MatchList(playerList);
        AdminList adminList = new AdminList();
        TeamList teamList = new TeamList(new ArrayList<>());
        TournamentList tournamentList = new TournamentList(new ArrayList<>());
        Controller controller = new Controller(playerList, matchList, teamList, adminList, tournamentList);



        this.commandList.add(new CreateCommand(controller));
        this.commandList.add(new RemoveCommand(controller));
        this.commandList.add(new RankCommand(controller));
        this.commandList.add(new ScoreCommand(controller));
        this.commandList.add(new ShowCommand(controller));
        this.commandList.add(new MatchmakeCommand(controller));
        this.commandList.add(new RandomMatchmakeCommand(controller));
        this.commandList.add(new ShowMatchmakeCommand(controller));
        this.commandList.add(new ClearMatchmakeCommand(controller));
        this.commandList.add(new LoginCommand(controller));
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
        enabledCommands.add(new StatisticsShowCommand(controller));
        enabledCommands.add(new TournamentAddCommand(controller));
        enabledCommands.add(new TournamentRemoveCommand(controller));
        enabledCommands.add(new LoginCommand(controller));
        enabledCommands.add(new LogoutCommand());
        enabledCommands.add(new TournamentListCommand(controller));
    }
    public void visit(Admin admin) {
        enabledCommands.add(new CreateCommand(controller));
        enabledCommands.add(new TeamCreateCommand(controller));
        enabledCommands.add(new PlayerDeleteCommand(controller));
        enabledCommands.add(new TeamDeleteCommand(controller));
        enabledCommands.add(new TeamAddCommand(controller));
        enabledCommands.add(new TeamRemoveCommand(controller));
        enabledCommands.add(new TournamentCreateCommand(controller));
        enabledCommands.add(new TournamentDeleteCommand(controller));
        enabledCommands.add(new TournamentMatchmakingCommand(controller));
        enabledCommands.add(new LoginCommand(controller));
        enabledCommands.add(new LogoutCommand());
        enabledCommands.add(new TournamentListCommand(controller));
    }

    public static void main(String[] args) {
        new CLI().execute();
    }
}
