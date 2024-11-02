package upm;

abstract class Command {
    private String preffix;

    public Command(String preffix){
        this.preffix = preffix;
    }
    public abstract void excute();

    public boolean isYours(String input){
        return input.startsWith(this.preffix);
    }
}
