package fr.etude.tennis.game.domain.tennis.model.state;

public enum GameStateEnum {
    DEUCE("Deuce"),
    ADVANTAGE("Advantage");

    private String value;

    GameStateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}


