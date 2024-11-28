package upm.view;

public class ErrorView {

    protected static final String[] MESSAGES = {
            "Player not found.",
            "Player already exists.",
            "Invalid command.",
            "Match already exists.",
            "Player not authenticated."
    };

    public abstract void show(Error error);
}
