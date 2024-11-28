package upm;

import upm.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CLI {
    private final List<Command> commandList = new ArrayList<>();
    private PlayerController playerController = new PlayerController(new ArrayList<>());
    private MatchController matchController = new MatchController(this.playerController) ;

    public CLI() {
        commandList.add(new CreateCommand(this.playerController));
        commandList.add(new RemoveCommand(this.playerController));
        commandList.add(new RankCommand(this.playerController));
        commandList.add(new ScoreCommand(this.playerController));
        commandList.add(new ShowCommand(this.playerController));
        commandList.add(new MatchmakeCommand(this.matchController, this.playerController));
        commandList.add(new RandomMatchmakeCommand(this.playerController, this.matchController));
        commandList.add(new ShowMatchmakeCommand(this.matchController));
        commandList.add(new ClearMatchmakeCommand(this.matchController));
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
                command.execute(input.split("[\\s;]+"));
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