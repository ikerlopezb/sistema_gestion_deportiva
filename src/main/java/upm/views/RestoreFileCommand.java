package upm.views;

import upm.utils.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class RestoreFileCommand {
    Controller controller;
    FileReader reader;

    {
        try {
            reader = new FileReader("entrada.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
