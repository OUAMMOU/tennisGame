package fr.etude.tennis.game.domain.tennis.model.state;


import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.Game;

/**
 * Functional interface representing the state of a tennis game.
 */
public interface GameState {

    void winPoint(Player player, Game game);
}
