package upm.utils;

public enum Error {
    PLAYER_NOT_FOUND,
    PLAYER_ALREADY_EXISTS,
    PLAYER_ALREADY_MATCHED,
    COMMAND_NOT_FOUND,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }
}
