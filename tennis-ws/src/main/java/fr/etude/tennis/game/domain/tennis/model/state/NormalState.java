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
        return game.getPlayerAScore() == Game.FORTY && game.getPlayerBScore() == Game.FORTY;
    }

    private boolean isPlayerAWinner(Game game, PlayerEnum playerName) {
        return playerName == PlayerEnum.A && game.getPlayerAScore() == Game.WIN && game.getPlayerBScore() < Game.FORTY;
    }

    private boolean isPlayerBWinner(Game game, PlayerEnum playerName) {
        return playerName == PlayerEnum.B && game.getPlayerBScore() == Game.WIN && game.getPlayerAScore() < Game.FORTY;
    }
}