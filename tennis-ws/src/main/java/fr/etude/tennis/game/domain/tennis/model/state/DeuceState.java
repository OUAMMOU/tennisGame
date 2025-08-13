package fr.etude.tennis.game.domain.tennis.model.state;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.TennisGame;

public class DeuceState implements GameState {
    @Override
    public void winPoint(Player player, TennisGame game) {
        game.setState(new AdvantageState(player));
        game.printAdvantage(player);
    }
}