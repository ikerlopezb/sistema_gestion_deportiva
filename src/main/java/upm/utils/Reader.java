package upm.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public abstract class Reader {
    private String label;
    private String linea;
    private BufferedReader in;

    public Reader(String label) {
        this.label = label;
    }

    public abstract void read(String input) throws IOException;

    public boolean isYours(String input) {
        return input.startsWith(this.label);
    }

    public String findLabel(BufferedReader in) throws IOException {
        while(!linea.startsWith(label)) {
            linea = in.readLine();
        }
        return linea;
    }
}
