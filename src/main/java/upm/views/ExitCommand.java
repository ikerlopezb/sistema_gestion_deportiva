package upm.views;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit");
    }

    public void execute(String[] input) { //no he sabido dónde ponerle porque es de ambos
        assert input.length == 1;
        System.out.println("Saliendo del programa...");
    }
}
