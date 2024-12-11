package upm.views;

import upm.utils.*;
import upm.utils.Error;
import upm.utils.models.Admin;
import upm.utils.models.Player;

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
        MatchList matchList = new MatchList();
        AdminList adminList = new AdminList();
        TeamList teamList = new TeamList(new ArrayList<>());
        TournamentList tournamentList = new TournamentList(new ArrayList<>());
        Controller controller = new Controller(playerList, matchList, teamList, adminList, tournamentList);
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
                error.writeln(Error.NULL);
            } else {
                error.writeln(Error.COMMAND_NOT_FOUND);
            }
        } while (!input.startsWith("exit"));
    }

    public void visit(Player player) {
        enabledCommands.clear();
        enabledCommands.add(new StatisticsShowCommand(controller));
        enabledCommands.add(new TournamentAddCommand(controller));
        enabledCommands.add(new TournamentRemoveCommand(controller));
        publicCommands();
    }

    public void visit(Admin admin) {
        enabledCommands.clear();
        enabledCommands.add(new CreateCommand(controller));
        enabledCommands.add(new TeamCreateCommand(controller));
        enabledCommands.add(new PlayerDeleteCommand(controller));
        enabledCommands.add(new TeamDeleteCommand(controller));
        enabledCommands.add(new TeamAddCommand(controller));
        enabledCommands.add(new TeamRemoveCommand(controller));
        enabledCommands.add(new TournamentCreateCommand(controller));
        enabledCommands.add(new TournamentDeleteCommand(controller));
        enabledCommands.add(new TournamentMatchmakingCommand(controller));
        enabledCommands.add(new ClearMatchmakeCommand());
        publicCommands();
    }

    private void publicCommands() {
        enabledCommands.add(new LoginCommand(controller));
        enabledCommands.add(new LogoutCommand());
        enabledCommands.add(new TournamentListCommand(controller));
    }

    public void tournamentList(Player player) {
        controller.showTournamentList();
    }

    public void tournamentList(Admin admin) {
        controller.removeFinishedTournaments();
        controller.showTournamentList();
    }

    public static void main(String[] args) {
        new CLI().execute();
    }
}
