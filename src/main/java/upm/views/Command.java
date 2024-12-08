package upm.views;


public abstract class Command {
    private String preffix;

    public Command(String preffix) {
        this.preffix = preffix;
    }

    public abstract void execute(String[] input);

    public boolean isYours(String input) {
        return input.startsWith(this.preffix);
    }

}