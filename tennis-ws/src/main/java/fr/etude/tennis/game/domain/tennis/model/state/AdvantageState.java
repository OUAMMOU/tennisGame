package fr.etude.tennis.game.domain.tennis.model.state;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.TennisGame;

public class AdvantageState implements GameState {

    private final Player advantagedPlayer;

    public AdvantageState(Player advantagedPlayer) {
        this.advantagedPlayer = advantagedPlayer;
    }

    @Override
    public void winPoint(Player player, TennisGame game) {
        if (player.getName() == advantagedPlayer.getName()) {
            game.printWinner(player);
            game.setWinner(player);
        } else {
            game.setState(new DeuceState());
            String message = GameStateEnum.DEUCE.getValue();
            System.out.println(message);
        }
    }

}