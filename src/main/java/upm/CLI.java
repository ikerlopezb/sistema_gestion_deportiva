package upm;

import upm.commands.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import upm.MatchList;
import upm.Match;

public class CLI {
    private final List<Command> commandList = new ArrayList<>();
    private PlayerList playerList = new PlayerList(new ArrayList<>());
    private MatchList matchList = new MatchList(this.playerList) ;

    public CLI() {
        commandList.add(new CreateCommand(this.playerList));
        commandList.add(new RemoveCommand(this.playerList));
        commandList.add(new RankCommand(this.playerList));
        commandList.add(new ScoreCommand(this.playerList));
        commandList.add(new ShowCommand(this.playerList));
        commandList.add(new MatchmakeCommand(this.matchList, this.playerList));
        commandList.add(new RandomMatchmakeCommand(this.playerList, this.matchList));
        commandList.add(new ShowMatchmakeCommand(this.matchList));
        commandList.add(new ClearMatchmakeCommand(this.matchList));
        commandList.add(new ExitCommand());
    }

    private void execute() {
        String input;
        String commandName;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Introduce el comando");
            input = scanner.nextLine().toLowerCase();
            commandName = input.split(" ")[0].trim();
            int i = 0;
            Command command = commandList.get(i);
            while (i < this.commandList.size() && !command.isYours(commandName)) {
                i++;
                command = commandList.get(i);
            }
            if (command.isYours(commandName)) {
                command.execute(input.split("[ ;]+"));
            } else {
                System.out.println("Command not found");
            }

        } while (!commandName.equals("exit"));
    }

    public static void main(String[] args) {
        new CLI().execute();
    }

    /**
     public class CLI {
     private final List<Command> commands = new ArrayList<>();

     public CLI() {
     // Agrega instancias de cada comando a la lista
     commands.add(new CreateCommand("create"));
     commands.add(new RemoveCommand("remove"));
     // Agrega más comandos según los tengas definidos
     }

     private void execute() {
     Scanner scanner = new Scanner(System.in);
     String input;

     do {
     System.out.println("Introduce el comando:");
     input = scanner.nextLine().trim();

     boolean commandFound = false;
     for (Command command : commands) {
     if (command.isYours(input)) {
     command.execute(input.split(" ")); // Llamada a execute con los argumentos
     commandFound = true;
     break;
     }
     }

     if (!commandFound) {
     System.out.println("Unknown command: " + input);
     }

     } while (!input.equals("exit"));

     System.out.println("Exiting program.");
     }

     public static void main(String[] args) {
     new CLI().execute();
     }
     }
     **/


    // main aqui
    // hacer un metodo execute nuevo(do while lo que escriba al usuario)
    //Funciona Iker
}