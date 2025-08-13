package fr.etude.tennis.game.domain.tennis.service;

import fr.etude.tennis.game.domain.exception.BusinessException;
import fr.etude.tennis.game.domain.exception.BusinessExceptionEnum;
import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.TennisGame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerService {

    public TennisGame calculateWinner(List<Player> players) {
        validatePlayers(players);
        TennisGame game = startGame(players);
        determineWinner(game);
        return game;
    }

    private void validatePlayers(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new BusinessException(BusinessExceptionEnum.PLAYERS_NULL);
        }
        if (players.size() < 2) {
            throw new BusinessException(BusinessExceptionEnum.INVALID_PLAYER);
        }
    }

    private TennisGame startGame(List<Player> players) {
        TennisGame game = new TennisGame();
        players.forEach(game::winPoint);
        return game;
    }

    private void determineWinner(TennisGame game) {
        if (game.getWinner() == null) {
            throw new BusinessException(BusinessExceptionEnum.GAME_NOT_FINISHED);
        }
    }

}
