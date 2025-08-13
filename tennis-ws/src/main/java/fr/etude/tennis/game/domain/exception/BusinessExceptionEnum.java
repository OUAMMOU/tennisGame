package fr.etude.tennis.game.domain.exception;

public enum BusinessExceptionEnum {
    PLAYERS_NULL("Players list cannot be null or empty"),
    INVALID_PLAYER("Number of players must be two"),
    GAME_NOT_FINISHED("Game is not finished, so no winner can be declared");

    private final String message;

    BusinessExceptionEnum(String message) {
        this.message = message;
    }
}
