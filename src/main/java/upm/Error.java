package upm;

public enum Error {
    PLAYER_NOT_FOUND,
    PLAYER_ALREADY_EXISTS,
    INVALID_COMMAND,
    MATCH_ALREADY_EXISTS,
    PLAYER_NOT_AUTHENTICATED,
    PLAYER_ALREADY_MATCHED,
    COMMAND_NOT_FOUND,
    NULL;
    public boolean isNull() {
        return this == Error.NULL;
    }
}
