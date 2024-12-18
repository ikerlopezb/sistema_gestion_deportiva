package upm.views;

import upm.utils.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class RestoreFileCommand extends Command{
    private Controller controller;
    private FileReader reader;

    public RestoreFileCommand(Controller controller) {
        super("restore-file");
        this.controller = controller;
    }
    public void execute(String[] input){
        try {
            reader = new FileReader("entrada.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
