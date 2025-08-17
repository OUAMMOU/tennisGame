package fr.etude.tennis.game.app.adapter;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.Game;
import fr.etude.tennis.game.domain.tennis.port.api.WinnerApiPort;
import fr.etude.tennis.game.domain.tennis.service.WinnerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WinnerApiAdapter implements WinnerApiPort {

    private final WinnerService winnerService;

    public WinnerApiAdapter(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @Override
    public Game getWinner(List<Player> players) {
        return winnerService.calculateWinner(players);
    }


}
