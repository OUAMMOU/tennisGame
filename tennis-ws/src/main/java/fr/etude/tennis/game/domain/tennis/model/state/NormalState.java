package fr.etude.tennis.game.domain.tennis.model.state;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.PlayerEnum;
import fr.etude.tennis.game.domain.tennis.model.Game;

public class NormalState implements GameState {

    @Override
    public void winPoint(Player player, Game game) {
        game.incrementScore(player);

        if (isDeuce(game)) {
            game.setState(new DeuceState());
            game.printScore();
            System.out.println(GameStateEnum.DEUCE);
        } else if (isPlayerAWinner(game, player.getName())) {
            game.setWinner(player);
            game.printWinner(player);
        } else if (isPlayerBWinner(game, player.getName())) {
            game.setWinner(player);
            game.printWinner(player);
        } else {
            game.printScore();
        }


    }

    private boolean isDeuce(Game game) {
        return game.getPlayerAScore() == 40 && game.getPlayerBScore() == 40;
    }

    private boolean isPlayerAWinner(Game game, PlayerEnum playerName) {
        return playerName == PlayerEnum.A && game.getPlayerAScore() == -1 && game.getPlayerBScore() < 40;
    }

    private boolean isPlayerBWinner(Game game, PlayerEnum playerName) {
        return playerName == PlayerEnum.B && game.getPlayerBScore() == -1 && game.getPlayerAScore() < 40;
    }
}