package fr.etude.tennis.game.domain.tennis.model;

public enum PlayerEnum {
    A('A'),

    B('B');

    private final char name;

    PlayerEnum(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
}
