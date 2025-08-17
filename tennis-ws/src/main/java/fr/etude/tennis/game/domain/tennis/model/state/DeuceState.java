package fr.etude.tennis.game.domain.tennis.model.state;

import fr.etude.tennis.game.domain.tennis.model.Game;
import fr.etude.tennis.game.domain.tennis.model.Player;

public class DeuceState implements GameState {
    @Override
    public void winPoint(Player player, Game game) {
        game.setState(new AdvantageState(player));
        game.printAdvantage(player);
    }
}