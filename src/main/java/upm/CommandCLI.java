package upm;

public enum CommandCLI  {
    CREATE(new CreateCommand()),
    REMOVE(new RemoveCommand()),
    SHOW(new ShowCommand()),
    SCORE(new ScoreCommand()),
    RANK(new RankCommand()),
    MATCHMAKE(new MatchmakeCommand()),
    CLEAR_MATCHMAKE(new ClearMatchmakeCommand()),
    SHOW_MATCHMAKE(new ShowMatchmakeCommand()),
    RANDOM_MATCHMAKE(new RandomMatchmakeCommand()),
    EXIT(new ExitCommand());

    private Command command;

    CommandCLI(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static Command getCommandByName(String name) {
        for (CommandCLI cliCommand : CommandCLI.values()) {
            if (cliCommand.name().equals(name)) {
                return cliCommand.getCommand();
            }
        }
        return null;
    }
}