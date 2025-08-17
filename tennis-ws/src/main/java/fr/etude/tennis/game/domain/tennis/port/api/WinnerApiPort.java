package fr.etude.tennis.game.domain.tennis.port.api;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.Game;

import java.util.List;

public interface WinnerApiPort {

    Game getWinner(List<Player> players);

}
