package upm.views;

import upm.utils.Error;

public class ErrorView {

    protected static final String[] MESSAGES = {
            "Player not found.",
            "Player already exists.",
            "Player already mached",
            "Command not found"
    };

    public void writeln(Error error) {
        if (!error.isNull()) {
            System.out.println(MESSAGES[error.ordinal()]);
        }
    }
}
