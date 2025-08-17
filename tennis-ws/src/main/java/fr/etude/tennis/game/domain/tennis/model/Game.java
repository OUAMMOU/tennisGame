package fr.etude.tennis.game.domain.tennis.model;

import fr.etude.tennis.game.domain.tennis.model.state.GameState;
import fr.etude.tennis.game.domain.tennis.model.state.NormalState;

public class Game {
    private static final int ZERO = 0;
    private static final int FIFTEEN = 15;
    private static final int THIRTY = 30;
    public static final int FORTY = 40;
    public static final int WIN = -1;

    private GameState currentState;
    private Player a;
    private Player b;
    private Player winner;

    public Game() {
        this.currentState = new NormalState();
        initializePlayers();
    }

    private void initializePlayers() {
        a = new Player(PlayerEnum.A);
        b = new Player(PlayerEnum.B);
        a.addScore(0);
        b.addScore(0);
    }

    public void setState(GameState state) {
        this.currentState = state;
    }

    public Player getPlayerA() {
        return a;
    }

    public Player getPlayerB() {
        return b;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public int getPlayerAScore() {
        return a.getScores().getLast();
    }

    public int getPlayerBScore() {
        return b.getScores().getLast();
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    public void incrementScore(Player player) {
        if (player.getName() == PlayerEnum.A) {
            a.addScore(nextPoint(a.getScores().getLast()));
        } else {
            b.addScore(nextPoint(b.getScores().getLast()));
        }
    }

    private int nextPoint(int currentPoint) {
        return switch (currentPoint) {
            case ZERO -> FIFTEEN;
            case FIFTEEN -> THIRTY;
            case THIRTY -> FORTY;
            case FORTY -> WIN; // win the game
            default -> currentPoint;
        };
    }

    public void winPoint(Player player) {
        currentState.winPoint(player, this);
    }

    public void printScore() {
        String score = "Player A: %d / Player B: %d".formatted(a.getScores().getLast(), b.getScores().getLast());
        System.out.println(score);
    }

    public void printWinner(Player player) {
        String score = "Player %s wins the game".formatted(player.getName());
        System.out.println(score);
    }
}
