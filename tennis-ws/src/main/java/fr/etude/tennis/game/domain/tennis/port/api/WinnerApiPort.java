package fr.etude.tennis.game.domain.tennis.port.api;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.TennisGame;

import java.util.List;

public interface WinnerApiPort {

    TennisGame getWinner(List<Player> players);

}
