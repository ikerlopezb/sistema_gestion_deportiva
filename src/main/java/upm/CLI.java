package upm;

import upm.commands.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private final List<Command> commandList = new ArrayList<>();
    private PlayerList playerList = new PlayerList(new ArrayList<>());
    private MatchList matchList = new MatchList(this.playerList);

    public CLI() {
        commandList.add(new CreateCommand(this.playerList));
        commandList.add(new RemoveCommand());
        commandList.add(new RankCommand());
        commandList.add(new ScoreCommand());
        commandList.add(new ShowCommand());
        commandList.add(new MatchmakeCommand());
        commandList.add(new RandomMatchmakeCommand());
        commandList.add(new ShowMatchmakeCommand());
        commandList.add(new ClearMatchmakeCommand());
        commandList.add(new ExitCommand());
    }

    private void execute() {
        String input;
        String commandName;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Introduce el comando");
            input = scanner.nextLine();
            commandName = input.split(" ")[0].trim();
            int i = 0;
            Command command = commandList.get(i);
            while (i < commandList.size() && !command.isYours(commandName)) {
                i++;
                command = commandList.get(i);
            }
            if (command.isYours(commandName)) {
                command.execute(input.split(" "));
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