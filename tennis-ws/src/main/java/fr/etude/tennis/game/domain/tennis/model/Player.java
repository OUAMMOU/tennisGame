package fr.etude.tennis.game.domain.tennis.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private PlayerEnum name;
    private List<Integer> scores;

    public Player(PlayerEnum name) {
        this.name = name;
        this.scores = new ArrayList<>();
    }

    public PlayerEnum getName() {
        return name;
    }

    public void setName(PlayerEnum name) {
        this.name = name;
    }


    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public void addScore(int score) {
        this.scores.add(score);
    }
}