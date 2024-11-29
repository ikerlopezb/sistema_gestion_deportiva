package upm.view;

import upm.Error;
public class ErrorView {

    protected static final String[] MESSAGES = {
            "Player not found.",
            "Player already exists.",
            "Invalid command.",
            "Match already exists.",
            "Player not authenticated.",
            "Player already mached",
            "Command not found"
    };

    public void writeln(Error error){
        if(!error.isNull()) {
            System.out.println(MESSAGES[error.ordinal()]);
        }
    }
}
