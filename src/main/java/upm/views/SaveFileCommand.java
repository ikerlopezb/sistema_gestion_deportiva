package upm.views;

import java.io.FileWriter;
import java.io.IOException;

import upm.utils.Controller;

public class SaveFileCommand extends Command {
    private FileWriter writer;
    private Controller controller;

    public SaveFileCommand(Controller controller) {
        super("write-file");
        this.controller = controller;
    }

    public void execute(String[] input) {
        assert input.length == 1;
        try {
            writer = new FileWriter("salida.txt");
            controller.writeFile(writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
